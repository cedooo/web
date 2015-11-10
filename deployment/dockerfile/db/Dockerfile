FROM mysql:5.6

MAINTAINER cedo <cedoo@qq.com>

RUN mkdir /cedo

ADD blog.sql /cedo/blog.sql
ADD docker-entrypoint.sh /cedo/entrypoint.sh

ENTRYPOINT ["/cedo/entrypoint.sh"]
