CREATE DATABASE tron_gym_db
    WITH
    OWNER = tronadmin
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
GRANT ALL PRIVILEGES ON DATABASE tron_gym_db TO tronadmin;
\c tron_gym_db
