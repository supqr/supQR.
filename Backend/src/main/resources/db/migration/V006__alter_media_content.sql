ALTER TABLE media_content ADD COLUMN media LONGBLOB NOT NULL;
ALTER TABLE media_content ADD COLUMN video BOOLEAN NOT NULL DEFAULT FALSE;