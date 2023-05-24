from fastapi import FastAPI, Depends
from fastapi.security import HTTPBearer, HTTPAuthorizationCredentials
from pydantic import BaseModel
from starlette.middleware.cors import CORSMiddleware
from typing import Optional

from services import applicant_service, auth_service, job_posting_service, resume_service, vacancy_service, \
    grade_service
from services.direction_service import get_all_directions
from services.vacancy_service import get_vacancies_by_keywords_and_params

app = FastAPI()

origins = ["*"]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

security = HTTPBearer()

regions = [
    {1: "Москва"},
    {2: "Санкт-Петербург"},
    {3: "Казань"},
    {4: "Нижний Новгород"},
    {5: "Калининград"},
    {6: "Владивосток"},
]

TYPES = {
    1: "UX/UI Design",
    2: "Frontend",
    3: "Backend",
    4: "DevOps",
    5: "QA"
},


EMPLOYMENT = {
    "1": "Полная занятость",
    "2": "Частичная занятость",
    "3": "Контрактная работа",
    "4": "Стажировка"
}



# class VacancyByKeywordsBody(BaseModel):
#     keywords: str,
#     direction: Optional[str] = None,
#     salary: Optional[str] = None,
#     region: Optional[str] = None,
#     tags: Optional[str] = None,

@app.get("/api/v1/vacancies")
async def get_vacancies_by_keywords(
        keywords: str,
        direction_id: Optional[str] = None,
        salary: Optional[str] = None,
        employments: Optional[str] = None,
        tags: Optional[str] = None,
):
    print(direction_id, employments)
    try:
        items = get_vacancies_by_keywords_and_params(
            keywords=keywords,
            direction_id=direction_id,
            salary=salary,
            employments=employments,
        )
        return {
            "count": len(items),
            "items": items,
        }
    except Exception:
        return {
            "status": "error",
        }


@app.get("/api/v1/vacancy_info")
async def get_vacancy_info_by_vacancy_id(
        vacancy_id: str,
        credentials: HTTPAuthorizationCredentials = Depends(security)
):
    try:
        bearer_auth = credentials.credentials
        user_id = auth_service.decode_jwt(str(bearer_auth))["user_id"]

        vacancy = vacancy_service.get_vacancy_by_id(vacancy_id, user_id)
        if vacancy is not None:
            return vacancy
        else:
            return {
                "status": "error"
            }
    except Exception:
        return {
            "status": "error"
        }

@app.get("/api/v1/resumes")
async def get_resumes(
        credentials: HTTPAuthorizationCredentials= Depends(security)
):
    try:
        bearer_auth = credentials.credentials

        print(bearer_auth)
    # token = AuthService.create_jwt_token({
    #     "token": bearer_auth
    # })

        user_id = auth_service.decode_jwt(str(bearer_auth))["user_id"]
        resumes =  resume_service.get_resumes(user_id)
        print(resumes)
        return {
            "items": resumes
        }
    except Exception:
        return {
            "status": "error"
        }
    # for vacancy in vacancies:
    #     if vacancy["id"] == vacancy_id:
    #         return vacancy
    return {
        "count": 2,
        "items": [
            {
                "id": "2",
                "job_title": "Backend",
                "salary": 45000.00,
                "datetime": "2023-04-09",
            },
            {
                "id": "3",
                "job_title": "Frontend",
                "salary": 27000.00,
                "datetime": "2023-05-11",
            },
        ]
    }

class JobPostingBody(BaseModel):
    vacancy_id: str
    resume_id: str

fake_users_db = {
    "johndoe": {
        "username": "johndoe",
        "full_name": "John Doe",
        "email": "johndoe@example.com",
        "hashed_password": "$2b$12$EixZaYVK1fsbw1ZfbX3OXePaWxn96p36WQoeG6Lruj3vjPGga31lW",
        "disabled": False,
    }
}

security = HTTPBearer()

@app.post("/api/v1/job_posting")
async def post_job_posting(
        job_posting: JobPostingBody,
        credentials: HTTPAuthorizationCredentials= Depends(security)
):
    try:
        token = credentials.credentials

        tok = auth_service.create_jwt_token({
            "token": token
        })

        result = job_posting_service.create_job_posting(
            job_posting.vacancy_id,
            job_posting.resume_id,
        )
        if result is not None:
            return {
                "status": "success"
            }
        print(job_posting.vacancy_id, job_posting.resume_id, token, tok)
        # for vacancy in vacancies:
        #     if vacancy["id"] == vacancy_id:
        #         return vacancy
        return {
            "status": "success"
        }
    except Exception:
        return {
            "status": "error"
        }
class Token(BaseModel):
    access_token: str


class LoginBody(BaseModel):
    email: str
    password: str


@app.post("/api/v1/login")
async def login(
    body: LoginBody,
):
    try:
        user = auth_service.authenticate_user(body.email, body.password)

        if user is not None:
            access_token = auth_service.create_jwt_token(
                {
                    "user_id": user["id"]
                }
            )
            return {
                "access_token": access_token,
            }
        else:
            return {
                "status": "error",
            }
    except Exception:
        return {
            "status": "error",
        }


class SignUpBody(BaseModel):
    name: str
    phone: str
    email: str
    password: str


@app.post("/api/v1/signup")
async def sign_up(
    body: SignUpBody,
):
    try:
        result = auth_service.create_user(
            name=body.name,
            phone=body.phone,
            email=body.email,
            password=body.password
        )
        if result:
            return {
                "status": "success"
            }
        else:
            return {
                "status": "error"
            }
    except Exception:
        return {
            "status": "error",
        }

@app.get("/api/v1/directions")
async def get_directions(

):
    try:
        directions = get_all_directions()
        return {
            "items": directions
        }
    except Exception:
        return {
            "status": "error"
        }


class CreateResumeBody(BaseModel):
    job_title: str
    salary: float
    skills: str
    education: str
    work_experience: str
    grade_id: str
    address: str
@app.post("/api/v1/resume")
async def create_resume(
    body: CreateResumeBody,
    credentials: HTTPAuthorizationCredentials = Depends(security)
):
    try:
        token = credentials.credentials
        payload = auth_service.decode_jwt(token)
        print("11111", body, payload)
        result = resume_service.create_resume(
            applicant_id=payload["user_id"],
            job_title=body.job_title,
            salary=body.salary,
            skills=body.skills,
            education=body.education,
            work_experience=body.work_experience,
            grade_id=body.grade_id,
            address=body.address
        )
        if result:
            return {
                "status": "success"
            }
        else:
            return {
                "status": "error"
            }
    except Exception:
        return {
            "status": "error"
        }

@app.get("/api/v1/grades")
async def get_grades(

):
    try:
        grades = grade_service.get_all_grades()
        return {
            "items": grades
        }
    except Exception:
        return {
            "status": "error"
        }


@app.get("/api/v1/jobs_postings")
async def get_jobs_postings(
    credentials: HTTPAuthorizationCredentials = Depends(security)
):
    try:
        bearer_auth = credentials.credentials
        user_id = auth_service.decode_jwt(str(bearer_auth))["user_id"]
        jobs_postings = job_posting_service.get_jobs_postings(user_id)
        return {
            "items": jobs_postings
        }
    except Exception:
        return {
            "status": "error"
        }


class DeleteJobPostingBody(BaseModel):
    job_posting_id: str


@app.post("/api/v1/job_posting/delete")
async def delete_job_posting(
    body: DeleteJobPostingBody,
    credentials: HTTPAuthorizationCredentials = Depends(security)
):
    try:
        bearer_auth = credentials.credentials
        user_id = auth_service.decode_jwt(str(bearer_auth))["user_id"]
        id = job_posting_service.delete_job_posting(body.job_posting_id)
        if id is not None:
            return {
                "status": "success"
            }
        return {
            "status": "error"
        }
    except Exception:
        return {
            "status": "error"
        }

@app.get("/api/v1/vacancies/last_added")
async def get_last_added_vacancies():
    try:
        vacancies = vacancy_service.get_last_added_vacancies()

        if vacancies is not None:
            return {
                "items": vacancies
            }
        return {
            "status": "error"
        }
    except Exception:
        return {
            "status": "error"
        }


@app.get("/api/v1/vacancies/recommended")
async def get_recommended_vacancies(
    credentials: HTTPAuthorizationCredentials = Depends(security)
):
    try:
        bearer_auth = credentials.credentials
        user_id = auth_service.decode_jwt(str(bearer_auth))["user_id"]

        vacancies = vacancy_service.get_recommended_vacancies(user_id)

        if vacancies is not None:
            return {
                "items": vacancies
            }
        return {
            "status": "error"
        }
    except Exception:
        return {
            "status": "error"
        }

@app.get("/api/v1/resume")
async def get_recommended_vacancies(
    resume_id: str
):
    try:
        # bearer_auth = credentials.credentials
        # user_id = AuthService.decode_jwt(str(bearer_auth))["user_id"]

        resume = resume_service.get_resume(resume_id)

        if resume is not None:
            return resume
        return {
            "status": "error"
        }
    except Exception:
        return {
            "status": "error"
        }

class DeleteResumeBody(BaseModel):
    resume_id: str
@app.post("/api/v1/resume/delete")
async def delete_resume(
    body: DeleteResumeBody,
    credentials: HTTPAuthorizationCredentials = Depends(security)
):
    try:
        bearer_auth = credentials.credentials
        user_id = auth_service.decode_jwt(str(bearer_auth))["user_id"]
        id = resume_service.delete_resume(body.resume_id)
        if id is not None:
            return {
                "status": "success"
            }
        return {
            "status": "error"
        }
    except Exception:
        return {
            "status": "error"
        }

@app.get("/api/v1/applicant")
async def get_applicant(
    credentials: HTTPAuthorizationCredentials = Depends(security)
):
    try:
        bearer_auth = credentials.credentials
        user_id = auth_service.decode_jwt(str(bearer_auth))["user_id"]

        applicant = applicant_service.get_applicant(user_id=user_id)

        if applicant is not None:
            return applicant
        return {
            "status": "error"
        }
    except Exception:
        return {
            "status": "error"
        }