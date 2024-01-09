# Tutorial: Pemasangan Spring dengan GraphQL dan PostgreSQL menggunakan Docker

## Langkah 1: Memasang Docker

Pastikan Docker telah terpasang di sistem Anda. Jika belum, unduh dari [situs resmi Docker](https://www.docker.com/) dan ikuti instruksi pemasangannya.

## Langkah 2: Mendapatkan Docker Image PostgreSQL

Gunakan perintah berikut untuk menarik Docker image PostgreSQL dari Docker Hub:

```bash
docker pull alwanarr/mydbpost:latest

```
## Langkah 3 : Jalankan container docker
```bash
docker run -d --name my-postgres --network=db-network -p 5432:5432 -e POSTGRES_PASSWORD=admin -e POSTGRES_USER=postgres -e POSTGRES_DB=mydb alwanarr/mydbpost
```

## Langkah 4 : Clone Proyek Spring Boot dari Repositori GitHub
```bash
git clone https://github.com/username/nama-proyek.git
```


## Langkah 5 : Masuk ke Direktori Proyek
```bash
cd namaprojek
```

## Langkah 6 : Jalankan perintah maven
```bash
mvn install
```
lalu setelah itu jalan projek spring boot