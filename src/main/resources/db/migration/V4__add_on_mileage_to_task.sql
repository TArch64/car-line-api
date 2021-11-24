ALTER TABLE tasks
    ADD on_mileage INTEGER;

ALTER TABLE tasks
    ALTER COLUMN on_mileage SET NOT NULL;
