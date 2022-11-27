FROM nginx:1.14.1
MAINTAINER qiubw

ENV CONFIG_PATH /etc/nginx

RUN mkdir -p $CONFIG_PATH
ADD . $CONFIG_PATH/

RUN chmod a+x /etc/nginx/nginx.conf

EXPOSE 80