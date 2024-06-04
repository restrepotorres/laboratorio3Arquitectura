# Parcial final arquitectura de software udea 2024-1

1. Para correr el proyecto estando en la raiz del repo. Se crearan dos contenedores, uno para el backend y otro para la base de datos
    ```bash
    docker-compose up --build
    ```

    
2. Para ejecutra prometeus y grafana (tener la ipv4 de la maquina en el archivo prometeus.yml y configurar grafana para que obtenga los datos de el)
   ```bash
    docker pull prom/prometheus
    docker run -d -p 9090:9090 -v .\prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus
    docker run -d -p 3000:3000 grafana/grafana
    ```
