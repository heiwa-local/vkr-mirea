from fastapi import FastAPI
from starlette.middleware.cors import CORSMiddleware

app = FastAPI()

origins = ["*"]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

@app.get("/api/v1/vacancies")
def get_vacancies_by_keywords(
    keywords: str
):
    vacancies = [
        {
            "organization_name": "Google",
            "organization_logo_url": "123123",
            "job_title": "UI/UX Designer",
            "salary": 45000.00,
            "address": "Канада, Торонто"
        }
    ]

    return {
        "count": len(vacancies),
        "items": vacancies,
    }
