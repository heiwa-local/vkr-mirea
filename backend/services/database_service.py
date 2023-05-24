import psycopg2
import psycopg2.extras

from database_config import HOST, USER, PASSWORD, DATABASE


# from config import host, user, password, database

def fetch_all(query: str):
    try:
        conn = psycopg2.connect(
            host=HOST,
            user=USER,
            password=PASSWORD,
            database=DATABASE
        )

        with conn.cursor(cursor_factory=psycopg2.extras.DictCursor) as cursor:
            cursor.execute(query)
            conn.commit()
            return cursor.fetchall()
    except:
        print('Can`t establish connection to database')
    finally:
        conn.close()


def fetch_one(query: str):
    try:
        conn = psycopg2.connect(
            host=HOST,
            user=USER,
            password=PASSWORD,
            database=DATABASE
        )

        with conn.cursor(cursor_factory=psycopg2.extras.DictCursor) as cursor:
            cursor.execute(query)
            conn.commit()
            return cursor.fetchone()
    except:
        print('Can`t establish connection to database')
    finally:
        conn.close()


def post(query: str):
    conn = psycopg2.connect(
        host=HOST,
        user=USER,
        password=PASSWORD,
        database=DATABASE
    )
    print("-1")

    with conn.cursor() as cursor:
        print("-2")
        cursor.execute(query)
        print("-3")
        conn.commit()
        print("-4")
        return cursor.fetchone()

    print("-5")
    conn.close()
    print("-6")
