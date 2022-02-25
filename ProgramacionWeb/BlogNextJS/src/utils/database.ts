import {Pool} from 'pg'

let conn:any

if(!conn){
    conn = new Pool({
        user: 'postgres',
        password: '0936',
        host: 'localhost',
        port: 5432,
        database:'blog'
    });
}

export {conn}

