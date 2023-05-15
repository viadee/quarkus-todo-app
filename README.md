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
