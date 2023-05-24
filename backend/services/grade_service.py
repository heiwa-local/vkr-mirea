from services import database_service


def get_all_grades():
    try:
        query = f"SELECT * FROM v1.grade"
        result = database_service.fetch_all(query)
        print(result)
        grades = []
        for grade in result:
            grades.append(
                {
                    "id": grade["id"],
                    "name": grade["name"],
                }
            )
        print(grades)
        return grades
    except Exception:
        return None