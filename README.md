#database setup

initdb -D G:\Projects\pgdata -U postgres -W -E UTF8 -A scram-sha-256
pg_ctl -D ^"G^:^\Projects^\pgdata^" -l logfile start
