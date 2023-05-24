from datetime import timedelta, datetime
from typing import Union, Annotated

from fastapi import Depends
from fastapi.security import OAuth2PasswordBearer
from jose import JWTError, jwt
from passlib.context import CryptContext

from services import database_service
from crypto_config import SECRET_KEY, ALGORITHM

pwd_context = CryptContext(schemes=["bcrypt"], deprecated="auto")
oauth2_scheme = OAuth2PasswordBearer(tokenUrl="token")

fake_db = [
    {
        "id": "1",
        "email": "123",
        "password": "$2b$12$ankVaetVio156.NJEOI/jeFC2d3ad8ut2qmLRovk/d6MGIIFqRGt6"
    }
]
def verify_password(plain_password, hashed_password):
    return pwd_context.verify(plain_password, hashed_password)


def get_password_hash(password):
    return pwd_context.hash(password)


def get_user(email: str):
    try:
        print(email)
        id, name, phone, applicant_email, hash_password = database_service.fetch_one(f"SELECT * FROM v1.applicant WHERE email='{email}';")
        return {
            "id": id,
            "name": name,
            "email": applicant_email,
            "phone": phone,
            "hash_password": hash_password
        }
    except Exception:

        return None


def authenticate_user(email: str, password: str):
    user = get_user(email)
    print(user)
    if not user:
        return None
    if not verify_password(password, user["hash_password"]):
        return None
    return user


def create_jwt_token(data: dict, expires_delta: Union[timedelta, None] = None):
    to_encode = data.copy()
    if expires_delta:
        expire = datetime.utcnow() + expires_delta
    else:
        expire = datetime.now() + timedelta(minutes=7200)

    to_encode.update({"exp": expire})
    encoded_jwt = jwt.encode(to_encode, key=SECRET_KEY, algorithm=ALGORITHM)
    return encoded_jwt


def decode_jwt(token: Annotated[str, Depends(oauth2_scheme)]):
    try:
        return jwt.get_unverified_claims(token=token)
    except JWTError:
        return None


def create_user(
    name: str,
    phone: str,
    email: str,
    password: str,
):
    try:
        hash_password = get_password_hash(password)

        query = f"INSERT INTO v1.applicant (name, phone, email, hash_password) VALUES ('{name}', '{phone}', '{email}', '{hash_password}') RETURNING id;"
        id = database_service.post(query)
        if id is not None:
            return True
        else:
            return False
    except Exception:

        return False