# Imagem base do Nginx leve
FROM nginx:alpine

# Remove a configuração default do Nginx
RUN rm /etc/nginx/conf.d/default.conf

# Copia seu nginx.conf personalizado
COPY ./nginx/nginx.conf /etc/nginx/conf.d/default.conf

# Copia os arquivos estáticos do front
COPY ./frontend /usr/share/nginx/html

# Expondo porta 80
EXPOSE 80

# Comando padrão do Nginx
CMD ["nginx", "-g", "daemon off;"]
