from services import database_service


def get_applicant(
    user_id: str
):
    try:
        query = f"SELECT * FROM v1.applicant WHERE id = {user_id}"
        result = database_service.fetch_one(query)

        return {
            "id": result[0],
            "name": result[1],
            "phone": result[2],
            "email": result[3],
        }
    except Exception:
        return None