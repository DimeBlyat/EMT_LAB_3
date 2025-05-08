DROP MATERIALIZED VIEW IF EXISTS hosts_by_county;

CREATE MATERIALIZED VIEW hosts_by_county AS
SELECT c.id AS country_id, COUNT(h.id) AS host_country
FROM Country c
         LEFT JOIN Host h ON h.country_id = c.id
GROUP BY c.id;