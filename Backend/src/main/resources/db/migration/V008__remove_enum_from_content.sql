ALTER TABLE content ADD COLUMN media BOOLEAN DEFAULT FALSE;
UPDATE content SET media = true WHERE type = 'MEDIA';
ALTER TABLE content DROP COLUMN type;