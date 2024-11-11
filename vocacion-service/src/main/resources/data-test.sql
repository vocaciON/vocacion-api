INSERT INTO usuarios ( email, password, nombre, apellido_usuario, telefono, fecha_create, fecha_update, fecha_nacimiento, usuario_rol)
VALUES
    ('prueb@example.com', 'password1', 'Juan', 'Pérez', '9999991', '2023-10-01', '2023-10-01', '1990-05-15', 'USER'),
    ('ana@example.com', 'password2', 'Ana', 'Gómez', '9999992', '2023-10-01', '2023-10-01', '1992-08-22', 'USER'),
    ('maria@example.com', 'password3', 'María', 'López', '9999993', '2023-10-01', '2023-10-01', '1988-12-10', 'EXPERTO'),
    ('jose@example.com', 'password4', 'José', 'Martínez', '9999994', '2023-10-01', '2023-10-01', '1995-03-30', 'EXPERTO'),
    ('maurici@example.com', 'password5', 'Mauricio', 'Terrones', '9999995', '2023-12-01', '2023-12-01', '1895-03-30', 'USER');

INSERT INTO contenido_educativos (titulo_contenido, contenido, favorito, fecha_create, fecha_update, link)
VALUES
    ('Introducción a la Psicología', 'Contenido sobre los conceptos básicos de la psicología y sus ramas.', true, '2023-01-01 08:00:00', '2023-01-02 10:30:00', 'https://psicologia-introduccion.com'),
    ('Filosofía Contemporánea', 'Una exploración de los filósofos contemporáneos y sus teorías.', false, '2023-02-01 09:00:00', '2023-02-03 11:00:00', 'https://filosofia-contemporanea.com'),
    ('Geografía Mundial', 'Estudio de los continentes, países y recursos naturales del planeta.', true, '2023-03-01 10:00:00', '2023-03-02 12:00:00', 'https://geografia-mundial.com'),
    ('Aprender Idiomas', 'Guía sobre técnicas y recursos para aprender nuevos idiomas.', true, '2023-04-01 11:00:00', '2023-04-03 13:00:00', 'https://aprender-idiomas.com'),
    ('Fundamentos de Ingeniería', 'Descripción de los principios básicos de la ingeniería en diversas disciplinas.', true, '2023-05-01 12:00:00', '2023-05-04 14:00:00', 'https://fundamentos-ingenieria.com');
INSERT INTO perfiles (descripcion, grado_academico, institucion_estudio, carrer_interes, fecha_create, fecha_update,usuario_id,contenido_educativo_id)
VALUES
    ('Estudiante de primer año con interés en programación.', 'Primer año', 'Universidad Privada Antenor Orrego', 'Ingeniería en Sistemas', '2023-01-01 08:00:00', '2023-01-01 08:30:00',1,1),
    ('Estudiante de segundo año con interés en diseño gráfico.', 'Segundo año', 'Universidad César Vallejo', 'Diseño Gráfico', '2023-02-01 09:00:00', '2023-02-01 09:30:00',2,2),
    ('Estudiante de tercer año con interés en administración de empresas.', 'Tercer año', 'Universidad de Trujillo', 'Administración de Empresas', '2023-03-01 10:00:00', '2023-03-01 10:30:00',3,3),
    ('Estudiante de cuarto año con interés en medicina.', 'Cuarto año', 'Universidad Nacional de Trujillo', 'Medicina', '2023-04-01 11:00:00', '2023-04-01 11:30:00',4,4),
    ('Estudiante de quinto año con interés en educación.', 'Quinto año', 'Universidad Privada del Norte', 'Educación', '2023-05-01 12:00:00', '2023-05-01 12:30:00',5,5);







INSERT INTO expertos (estudios, especialidad, informacion_personal, disponibilidad, fecha_create, fecha_update,usuario_id)
VALUES
    ('Ingeniería en Sistemas', 'Desarrollo de Software', 'Experto en tecnologías web con 10 años de experiencia.', true, '2023-01-01 08:00:00', '2023-01-01 08:30:00',1),
    ('Licenciatura en Psicología', 'Psicología Clínica', 'Psicólogo clínico especializado en terapia cognitivo-conductual.', false, '2023-02-01 09:00:00', '2023-02-01 09:30:00',2),
    ('Maestría en Educación', 'Educación a Distancia', 'Experto en metodologías de enseñanza virtual.', true, '2023-03-01 10:00:00', '2023-03-01 10:30:00',3),
    ('Licenciatura en Medicina', 'Medicina General', 'Médico general con experiencia en atención primaria.', true, '2023-04-01 11:00:00', '2023-04-01 11:30:00',4),
    ('Ingeniería en Electrónica', 'Telecomunicaciones', 'Especialista en sistemas de comunicación y redes.', false, '2023-05-01 12:00:00', '2023-05-01 12:30:00',5);




INSERT INTO prueba_vocacions (nombre, descripcion, limite_tiempo, fecha_create, fecha_update)
VALUES
    ('Prueba de Orientación Vocacional', 'Evaluación para ayudar a los estudiantes a identificar sus intereses y carreras.', 30, '2023-01-01 08:00:00', '2023-01-01 08:30:00'),
    ('Prueba de Intereses Profesionales', 'Identifica los intereses que se alinean con diferentes carreras.', 45, '2023-02-01 09:00:00', '2023-02-01 09:30:00'),
    ('Prueba de Habilidades', 'Evalúa las habilidades prácticas y técnicas del estudiante.', 20, '2023-03-01 10:00:00', '2023-03-01 10:30:00'),
    ('Prueba de Estilos de Aprendizaje', 'Determina el estilo de aprendizaje más efectivo para el estudiante.', 25, '2023-04-01 11:00:00', '2023-04-01 11:30:00'),
    ('Prueba de Aptitudes', 'Evalúa las aptitudes generales y específicas del estudiante.', 30, '2023-05-01 12:00:00', '2023-05-01 12:30:00');


INSERT INTO resultado_pruebas (resultado, recomendaciones, feedback)
VALUES
    ('Alta orientación hacia ciencias exactas', 'Considera una carrera en ingeniería o matemáticas.', 'Buen desempeño en matemáticas y lógica.'),
    ('Intereses en humanidades', 'Explora carreras en psicología o educación.', 'Interés notable en temas sociales y literarios.'),
    ('Habilidades en tecnología', 'Carreras recomendadas en informática o diseño gráfico.', 'Muestra gran afinidad por las tecnologías digitales.'),
    ('Preferencia por trabajos en equipo', 'Podrías considerar administración de empresas o recursos humanos.', 'Buen trabajo colaborativo, habilidades interpersonales.'),
    ('Talento para resolver problemas prácticos', 'Carreras en ingeniería mecánica o arquitectura.', 'Excelente capacidad para pensar de manera crítica y creativa.');




INSERT INTO carreras (nombre, descripcion, fecha_create, fecha_update)
VALUES
    ('Ingeniería de Sistemas', 'Carrera orientada al desarrollo de sistemas y software.', '2023-10-01 10:00:00', '2023-10-01 10:00:00'),
    ('Psicología', 'Carrera enfocada en el estudio de la mente y comportamiento humano.', '2023-10-02 11:00:00', '2023-10-02 11:00:00'),
    ('Administración de Empresas', 'Preparación en gestión y administración de organizaciones.', '2023-10-03 12:00:00', '2023-10-03 12:00:00'),
    ('Medicina', 'Formación en atención médica y ciencias de la salud.', '2023-10-04 13:00:00', '2023-10-04 13:00:00'),
    ('Diseño Gráfico', 'Carrera orientada al diseño visual y multimedia.', '2023-10-05 14:00:00', '2023-10-05 14:00:00');

INSERT INTO compra_planes (costo, nombre, descripcion_plan, fecha_create)
VALUES
    (99.99, 'Plan Básico', 'Acceso limitado a recursos', '2023-01-01 10:00:00'),
    (199.99, 'Plan Premium', 'Acceso a todos los recursos con soporte prioritario', '2023-02-01 10:30:00'),
    (299.99, 'Plan Empresarial', 'Acceso a recursos premium y herramientas empresariales', '2023-03-01 11:00:00'),
    (29.89, 'Plan Básico', 'Acceso limitado a recursos', '2025-01-01 10:00:00'),
    (59.59, 'Plan Básico', 'Acceso limitado a recursos', '2028-01-01 10:00:00');
INSERT INTO pagos (monto, fecha_create, fecha_update, estado_pago,usuario_id,compra_plan_id)
VALUES
    (150.50, '2023-11-01 10:00:00', '2023-11-01 10:00:00', 'PENDING',1,1),
    (200.00, '2023-11-02 11:30:00', '2023-11-02 11:30:00',  'PENDING',2,2),
    (300.75, '2023-11-03 14:45:00', '2023-11-03 14:45:00',  'PENDING',3,3),
    (250.00, '2023-11-04 16:00:00', '2023-11-04 16:00:00',  'PENDING',4,4),
    (100.00, '2023-11-05 09:15:00', '2023-11-05 09:15:00', 'PENDING',5,5);



INSERT INTO preguntas (descripcion, fecha_create, fecha_update)
VALUES
    ('¿Cuál es tu carrera ideal?', '2023-11-01 10:00:00', '2023-11-01 10:00:00'),
    ('¿Prefieres el trabajo en equipo?', '2023-11-02 11:30:00', '2023-11-02 11:30:00'),
    ('¿Te consideras una persona creativa?', '2023-11-03 14:45:00', '2023-11-03 14:45:00'),
    ('¿Disfrutas el trabajo al aire libre?', '2023-11-04 16:00:00', '2023-11-04 16:00:00'),
    ('¿Qué tan importante es la estabilidad laboral para ti?', '2023-11-05 09:15:00', '2023-11-05 09:15:00');


INSERT INTO respuestas (descripcion, es_correcto, fecha_create)
VALUES
    ('Ingeniería de Sistemas', true, '2023-11-01 10:00:00'),
    ('Trabajo en equipo', true, '2023-11-02 11:30:00'),
    ('Sí, me considero creativo', true, '2023-11-03 14:45:00'),
    ('Sí, disfruto el aire libre', true, '2023-11-04 16:00:00'),
    ('Muy importante', true, '2023-11-05 09:15:00');


INSERT INTO respuesta_usuarios ( fecha_create, fecha_update)
VALUES
    ( '2023-11-06 10:00:00', '2023-11-06 10:00:00'),
    ( '2023-11-07 11:30:00', '2023-11-07 11:30:00'),
    ( '2023-11-08 14:45:00', '2023-11-08 14:45:00'),
    ( '2023-11-09 16:00:00', '2023-11-09 16:00:00'),
    ( '2023-11-10 09:15:00', '2023-11-10 09:15:00');


INSERT INTO asesorias (tema_tratar, fecha_asesoria, link_asesoria, costo, estado_asesoria)
VALUES
    ('Asesoría en Marketing Digital', '2024-10-01', 'https://link1.com', 100.0, 'PENDIENTE'),
    ('Asesoría Financiera', '2024-10-02', 'https://link2.com', 150.0, 'FINALIZADA'),
    ('Asesoría en Desarrollo Personal', '2024-10-03', 'https://link3.com', 200.0, 'PENDIENTE'),
    ('Asesoría en Programación', '2024-10-04', 'https://link4.com', 250.0, 'FINALIZADA'),
    ('Asesoría en Diseño Gráfico', '2024-10-05', 'https://link5.com', 300.0, 'PENDIENTE');