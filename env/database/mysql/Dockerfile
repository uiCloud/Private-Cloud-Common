# 需要指定版本，避免不同版本下 /var/lib/mysql 数据格式不一致导致启动失败
FROM mysql:8
MAINTAINER qiubw

ENV AUTO_RUN_PATH /docker-entrypoint-initdb.d

RUN mkdir -p $AUTO_RUN_PATH
# 把sql都放到容器中，官方镜像容器会自动执行/docker-entrypoint-initdb.d/*.sql
ADD . $AUTO_RUN_PATH/

RUN chown -R mysql /var/lib/mysql
RUN chown -R mysql /docker-entrypoint-initdb.d

EXPOSE 3306