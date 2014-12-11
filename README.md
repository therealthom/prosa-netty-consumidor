prosa-netty-consumidor
======================

Recibe trama ISO8583 y genera un archivo XML

Para que funcione JPos primero tenemos que instalarlo como bundle, dentro de karaf:

osgi:install -s wrap:mvn:org.jpos/jpos/1.9.8

Después instalar el bundle de prosa:

osgi:install -s mvn:mx.redhat.fuse/prosa-netty-consumidor/4.0.0