from services import database_service


def get_all_directions():
    try:
        query = f"SELECT * FROM v1.direction"
        result = database_service.fetch_all(query)
        directions = []
        for direction in result:
            directions.append(
                {
                    "id": direction["id"],
                    "name": direction["name"],
                }
            )
        return directions
    except Exception:
        return None
