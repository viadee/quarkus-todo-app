# TODO Applications with Quarkus

## Build/Tag/Push Docker Image

```bash
quarkus build -Dquarkus.container-image.build=true
```

Check the created image:
```bash
docker image ls
```

Tag the image:
```bash
docker tag <image-tag-from-previous-output> europe-west3-docker.pkg.dev/pulumi-challenge/cloudland/quarkus-todo-app:1.0
```

Push the image:
```bash
docker push europe-west3-docker.pkg.dev/pulumi-challenge/cloudland/quarkus-todo-app:1.0
```

## Profiles

The default settings configure the application for use with an in-memory H2 DB. Additionally, the application can be configured
to connect to a Postgres-DB running on Google Cloud SQL. This can be achieved by using the "cloudsql" profile at build time, e.g.
by using

```bash
quarkus build -Dquarkus.container-image.build=true -Dquarkus.profile=prod,cloudsql
```

to build the application / container image. Unfortunately, the cloudsql profile cannot be dynamically configured at run time,
as the property `quarkus.datasource.jdbc.driver` needs to be set and is one of the quarkus properties that need to be fixed 
at build time.

In addition, when using the cloudsql profile, the following properties need to be set, e.g. by using environment variables:

- `quarkus.datasource.username` (set this to the configured db user name),
- `quarkus.datasource.password` (set this to the configured db user password),
- `quarkus.datasource.jdbc.url` (set this to `jdbc://postgresql:///<db-name>`, where `<db-name>` is the name of the database created on Cloud SQL)
- `quarkus.datasource.jdbc.additional-jdbc-properties.cloudSqlInstance` (set this to the "instance connection name" of the instance on Cloud SQL)
