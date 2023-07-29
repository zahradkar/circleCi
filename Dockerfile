FROM ubuntu:latest
LABEL authors="Martin"

ENTRYPOINT ["top", "-b"]