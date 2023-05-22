from typing import Optional
import database


def get_vacancies_by_keywords_and_params(
    keywords: str,
    direction_id: Optional[str] = None,
    salary: Optional[str] = None,
    employments: Optional[str] = None,
):
    try:
        print(direction_id)
        keywords = keywords.replace("%", " ")
        filter_query = ""
        if direction_id is not None:
            filter_query += f" AND v1.vacancy.direction_id = {direction_id}"
            print(filter_query)
        if salary is not None:
            filter_query += f" AND v1.vacancy.salary >= {salary}"
        if employments is not None:
            filter_query += " AND ("
            for employment in employments.split(","):
                filter_query += f"v1.vacancy.employment_id = {employment} OR "
            filter_query = filter_query[:-4]
            filter_query += ")"
        print(keywords, direction_id)
        query = f"SELECT v1.vacancy.id, v1.organization.name, v1.organization.logo_url, v1.vacancy.job_title, v1.vacancy.salary, v1.vacancy.address FROM v1.vacancy JOIN v1.organization ON v1.vacancy.organization_id=v1.organization.id WHERE (v1.vacancy.job_title LIKE '%{keywords}%' OR v1.organization.name LIKE '%{keywords}%' OR v1.vacancy.description LIKE '%{keywords}%')" + filter_query
        print(query)
        result = database.fetch_all(query)

        vacancies = []
        for vacancy in result:
            vacancies.append(
                {
                    "id": vacancy[0],
                    "organization_name": vacancy[1],
                    "organization_logo_url": vacancy[2],
                    "job_title": vacancy[3],
                    "salary": vacancy[4],
                    "address": vacancy[5],
                }
            )
        return vacancies
    except Exception:
        print("Exe")


def get_vacancy_by_id(
    vacancy_id: str,
    user_id: str
):
    try:
        print(vacancy_id)
        query = f"SELECT v1.vacancy.id, v1.organization.name, v1.organization.logo_url, v1.vacancy.job_title, v1.vacancy.salary, v1.vacancy.address, v1.employment.name, v1.vacancy.description, v1.organization.description, v1.grade.name, v1.direction.name FROM v1.vacancy JOIN v1.organization ON v1.vacancy.organization_id=v1.organization.id  JOIN v1.employment ON v1.vacancy.employment_id=v1.employment.id JOIN v1.grade ON v1.vacancy.grade_id=v1.grade.id JOIN v1.direction ON v1.vacancy.direction_id=v1.direction.id WHERE v1.vacancy.id = {vacancy_id}"
        print(query)
        result = database.fetch_one(query)

        query2 = f"SELECT v1.resume.applicant_id, v1.job_posting.id FROM v1.job_posting JOIN v1.resume ON v1.job_posting.resume_id=v1.resume.id WHERE vacancy_id = {result[0]}"
        print("-----", query2)
        result2 = database.fetch_one(query2)
        print("123-123", result2)
        if result2 is not None:
            print("123-123", result2)
            print("-----1-----", result2[0], result2[1])
            if result2[0] == user_id:
                print("-----1-----", result2[0], result2[1])
                return {
                    "id": result[0],
                    "organization_name": result[1],
                    "organization_logo_url": result[2],
                    "job_title": result[3],
                    "salary": result[4],
                    "address": result[5],
                    "employment": result[6],
                    "description": result[7],
                    "organization_description": result[8],
                    "grade": result[9],
                    "direction": result[10],
                    "job_posting_id": result2[1],
                }

        return {
            "id": result[0],
            "organization_name": result[1],
            "organization_logo_url": result[2],
            "job_title": result[3],
            "salary": result[4],
            "address": result[5],
            "employment": result[6],
            "description": result[7],
            "organization_description": result[8],
            "grade": result[9],
            "direction": result[10],
        }
    except Exception:
        return None


def get_last_added_vacancies():
    try:
        query = f"SELECT v1.vacancy.id, v1.organization.name, v1.organization.logo_url, v1.vacancy.job_title, v1.vacancy.salary, v1.vacancy.address, v1.vacancy.datetime FROM v1.vacancy JOIN v1.organization ON v1.vacancy.organization_id=v1.organization.id ORDER BY v1.vacancy.datetime DESC"
        print(query)
        result = database.fetch_all(query)
        print(result)
        vacancies = []
        for vacancy in result:
            vacancies.append(
                {
                    "id": vacancy[0],
                    "organization_name": vacancy[1],
                    "organization_logo_url": vacancy[2],
                    "job_title": vacancy[3],
                    "salary": vacancy[4],
                    "address": vacancy[5],
                }
            )
        return vacancies
    except Exception:
        return {
            "status": "error"
        }


def get_recommended_vacancies(
    user_id: str
):
    try:
        query1 = f"SELECT job_title, skills FROM v1.resume WHERE applicant_id = {user_id}"
        result1 = database.fetch_all(query1)
        print(result1)
        param_query = ""
        for resume in result1:
            job_title = resume[0]
            skills = str(resume[1]).split(",")
            param_query += f" OR v1.vacancy.job_title LIKE '%{job_title}%' OR "

            for skill in skills:
                if skill.replace(" ", "") != "":
                    param_query += f"v1.vacancy.job_title LIKE '%{skill}%' OR v1.vacancy.description LIKE '%{skill}%' OR "
            param_query = param_query[:-3]
        print("papa", len(param_query))
        if len(param_query) > 0:
            param_query = "WHERE " + param_query[4:]
        query = f"SELECT v1.vacancy.id, v1.organization.name, v1.organization.logo_url, v1.vacancy.job_title, v1.vacancy.salary, v1.vacancy.address, v1.vacancy.datetime FROM v1.vacancy JOIN v1.organization ON v1.vacancy.organization_id=v1.organization.id " + param_query
        print(query)
        result = database.fetch_all(query)
        print(result)
        vacancies = []
        for vacancy in result:
            vacancies.append(
                {
                    "id": vacancy[0],
                    "organization_name": vacancy[1],
                    "organization_logo_url": vacancy[2],
                    "job_title": vacancy[3],
                    "salary": vacancy[4],
                    "address": vacancy[5],
                }
            )
        return vacancies
    except Exception:
        return {
            "status": "error"
        }