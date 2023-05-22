import datetime as dt
import database


def create_resume(
    applicant_id: str,
    job_title: str,
    salary: float,
    skills: str,
    education: str,
    work_experience: str,
    grade_id: str,
    address: str
):
    try:
        datetime = dt.datetime.now()
        formatted_datetime = f"{datetime.year}-{datetime.month}-{datetime.day}"
        query = f"INSERT INTO v1.resume (applicant_id, job_title, salary, skills, education, work_experience, datetime, grade_id, address) VALUES ({applicant_id}, '{job_title}', {salary}, '{skills}', '{education}', '{work_experience}', '{formatted_datetime}', {grade_id}, '{address}') RETURNING id;"
        print(query)
        id = database.post(query)
        if id is not None:
            return True
        else:
            return False
    except Exception:
        return False


def get_resumes(
    applicant_id: str
):
    try:
        query = f"SELECT id, applicant_id, job_title, salary, skills, education, work_experience, datetime FROM v1.resume WHERE applicant_id = {applicant_id}"
        print(query)
        results = database.fetch_all(query)
        print(results)
        resumes = []
        for resume in results:
            resumes.append(
                {
                    "id": resume[0],
                    "applicant_id": resume[1],
                    "job_title": resume[2],
                    "salary": resume[3],
                    "skills": resume[4],
                    "education": resume[5],
                    "work_experience": resume[6],
                    "datetime": resume[7],
                }
            )
        return resumes

    except Exception:
        return None


def get_resume(
    resume_id: str
):
    try:
        query = f"SELECT * FROM v1.resume JOIN v1.grade ON v1.resume.grade_id=v1.grade.id WHERE v1.resume.id = {resume_id}"
        print(query)
        results = database.fetch_one(query)
        print(results)
        return {
            "id": results[0],
            "applicant_id": results[1],
            "job_title": results[2],
            "grade": results[11],
            "address": results[8],
            "salary": results[3],
            "skills": results[4],
            "education": results[5],
            "work_experience": results[6],
            "datetime": results[7],
        }

    except Exception:
        return None


def delete_resume(
    resume_id: str
):
    try:
        query = f"DELETE FROM v1.resume WHERE v1.resume.id = {resume_id} RETURNING id;"
        id = database.post(query)
        print(id)
        return id
    except Exception:
        return None