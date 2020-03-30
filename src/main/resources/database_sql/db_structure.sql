/*
PostgreSQL Backup
*/

DROP TABLE IF EXISTS "public"."patient";
DROP TABLE IF EXISTS "public"."vital_sign";
DROP VIEW IF EXISTS "public"."view_vitalsigns";
CREATE TABLE "patient" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "age" int4 NOT NULL,
  "dni" varchar(10) COLLATE "pg_catalog"."default" NOT NULL
)
;

CREATE TABLE "vital_sign" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "patient_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "blood_pressure_systolic" int4 NOT NULL,
  "blood_pressure_diastolic" int4 NOT NULL,
  "heart_rate" int4 NOT NULL,
  "registration_moment" timestamp(0) NOT NULL
)
;

CREATE VIEW "view_vitalsigns" AS  SELECT vital_sign.id,
    vital_sign.patient_id,
    vital_sign.blood_pressure_systolic,
    vital_sign.blood_pressure_diastolic,
    vital_sign.heart_rate,
    vital_sign.registration_moment,
    date_part('year'::text, vital_sign.registration_moment) AS year_registration,
    date_part('month'::text, vital_sign.registration_moment) AS month_registration
   FROM vital_sign;

ALTER TABLE "patient" ADD CONSTRAINT "patient_pkey" PRIMARY KEY ("id");
CREATE UNIQUE INDEX "uk_patient_dni" ON "patient" USING btree (
  "dni" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
ALTER TABLE "vital_sign" ADD CONSTRAINT "patient_copy1_pkey" PRIMARY KEY ("id");
ALTER TABLE "vital_sign" ADD CONSTRAINT "fk80dio1jup6u6e4qqr7rg1gaxr" FOREIGN KEY ("patient_id") REFERENCES "public"."patient" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
