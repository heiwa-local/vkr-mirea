import datetime as dt

import database


def create_job_posting(
    vacancy_id: str,
    resume_id: str,
):
    try:
        datetime = dt.datetime.now()
        formatted_datetime = f"{datetime.year}-{datetime.month}-{datetime.day}"
        query = f"INSERT INTO v1.job_posting (resume_id, vacancy_id, status, datetime) VALUES ({resume_id}, {vacancy_id}, 'Не просмотрено', '{formatted_datetime}') RETURNING id;"
        print(query)
        id = database.post(query)
        if id is not None:
            return True
        else:
            return None
    except Exception:
        return None


def get_jobs_postings(
    user_id: str
):
    try:
        query = f"SELECT v1.job_posting.id, v1.job_posting.vacancy_id, v1.job_posting.resume_id, v1.vacancy.job_title, v1.organization.name, v1.organization.logo_url, v1.job_posting.status, v1.job_posting.datetime FROM v1.job_posting JOIN v1.resume ON v1.job_posting.resume_id=v1.resume.id JOIN v1.vacancy ON v1.job_posting.vacancy_id=v1.vacancy.id JOIN v1.organization ON v1.vacancy.organization_id=v1.organization.id WHERE v1.resume.applicant_id = {user_id}"
        print(query)
        result = database.fetch_all(query)
        print(result)
        jobs_postings = []
        for job_posting in result:
            jobs_postings.append(
                {
                    "id": job_posting[0],
                    "vacancy_id": job_posting[1],
                    "resume_id": job_posting[2],
                    "vacancy_job_title": job_posting[3],
                    "organization_name": job_posting[4],
                    "organization_logo_url": job_posting[5],
                    "status": job_posting[6],
                    "datetime": job_posting[7],
                }
            )
        return jobs_postings
    except Exception:
        return None


def delete_job_posting(
    job_posting_id: str
):
    try:
        query = f"DELETE FROM v1.job_posting WHERE v1.job_posting.id = {job_posting_id} RETURNING id;"
        id = database.post(query)
        print(id)
        return id
    except Exception:
        return None
