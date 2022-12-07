#!/bin/bash
set -e

PGPASSWORD="$POSTGRES_PASSWORD" psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "hib" -f /docker-entrypoint-initdb.d/sql/01-postgres.sql
