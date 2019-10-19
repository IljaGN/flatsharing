#!/bin/bash

scriptdir=$(cd `dirname $0` && pwd)
cd $scriptdir/src/test/resources
PGPASSWORD='local' psql -hlocalhost -Uflatsharing flatsharingdb < schema.sql
PGPASSWORD='local' psql -hlocalhost -Uflatsharing flatsharingdb < data.sql
