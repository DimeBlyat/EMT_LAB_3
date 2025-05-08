DROP MATERIALIZED VIEW IF EXISTS accommodation_by_host;

CREATE MATERIALIZED VIEW accommodation_by_host AS
       SELECT h.id AS host_id, COUNT (a.id) AS accommodation_count
       FROM Host h
       LEFT JOIN Accommodation a ON a.host_id = h.id
       GROUP BY h.id;