INSERT INTO usuarios (email, password, nombre, apellido_usuario, telefono, fecha_create, fecha_update, fecha_nacimiento)
VALUES
    ('prueb@example.com', 'password1', 'Juan', 'Pérez', '9999991', '2023-10-01', '2023-10-01', '1990-05-15'),
    ('ana@example.com', 'password2', 'Ana', 'Gómez', '9999992', '2023-10-01', '2023-10-01', '1992-08-22'),
    ('maria@example.com', 'password3', 'María', 'López', '9999993', '2023-10-01', '2023-10-01', '1988-12-10'),
    ('jose@example.com', 'password4', 'José', 'Martínez', '9999994', '2023-10-01', '2023-10-01', '1995-03-30');


INSERT INTO asesorias (tema_tratar, fecha, link_asesoria, costo)
VALUES
    ('Asesoría en Marketing Digital', '2024-10-01', 'https://link1.com', 100.0),
    ('Asesoría Financiera', '2024-10-02', 'https://link2.com', 150.0),
    ('Asesoría en Desarrollo Personal', '2024-10-03', 'https://link3.com', 200.0),
    ('Asesoría en Programación', '2024-10-04', 'https://link4.com', 250.0),
    ('Asesoría en Diseño Gráfico', '2024-10-05', 'https://link5.com', 300.0);

INSERT INTO contenido_educativos(titulo_contenido, tipo, contenido, favorito, link)
values
('titulo contenido uno', 'psicologia', 'asdasd', true, 'www.s' ),
('titulo contenido dos', 'filosofia', 'eff', false, 'www.s' ),
('titulo contenido tres', 'geografia', 'asfffdasd', true, 'www.s' ),
('titulo contenido cuatro', 'idiomas', 'ffff', true, 'www.s' ),
('titulo contenido cinco', 'ingenieria', 'asfffdasd', true, 'www.s' );

INSERT INTO expertos (estudios, edad_experto, especialidad, informacion_personal, calificacion, disponibilidad)
VALUES
    ('Ingeniería en Sistemas', '1985-06-15', 'Desarrollo de Software', 'Experto en tecnologías web con 10 años de experiencia.', 'A', 'Disponible'),
    ('Licenciatura en Psicología', '1990-11-20', 'Psicología Clínica', 'Psicólogo clínico especializado en terapia cognitivo-conductual.', 'B', 'No disponible'),
    ('Maestría en Educación', '1980-02-05', 'Educación a Distancia', 'Experto en metodologías de enseñanza virtual.', 'A', 'Disponible'),
    ('Licenciatura en Medicina', '1988-04-25', 'Medicina General', 'Médico general con experiencia en atención primaria.', 'A', 'Disponible'),
    ('Ingeniería en Electrónica', '1982-09-30', 'Telecomunicaciones', 'Especialista en sistemas de comunicación y redes.', 'C', 'No disponible');

INSERT INTO perfiles (descripcion, edad_estudiante, grado_academico, institucion_estudio, carrer_interes)
VALUES
    ('Estudiante de primer año con interés en programación.', 18, 'Primer año', 'Universidad Privada Antenor Orrego', 'Ingeniería en Sistemas'),
    ('Estudiante de segundo año con interés en diseño gráfico.', 19, 'Segundo año', 'Universidad César Vallejo', 'Diseño Gráfico'),
    ('Estudiante de tercer año con interés en administración de empresas.', 20, 'Tercer año', 'Universidad de Trujillo', 'Administración de Empresas'),
    ('Estudiante de cuarto año con interés en medicina.', 21, 'Cuarto año', 'Universidad Nacional de Trujillo', 'Medicina'),
    ('Estudiante de quinto año con interés en educación.', 22, 'Quinto año', 'Universidad Privada del Norte', 'Educación');

INSERT INTO prueba_vocacions (nombre, descripcion, tipo, preguntas, respuestas, limite_tiempo)
VALUES
    ('Prueba de Orientación Vocacional', 'Evaluación para ayudar a los estudiantes a identificar sus intereses y carreras.', 'Orientación', '1. ¿Qué materias disfrutas más?; 2. ¿Te gusta trabajar en equipo?', 'Matemáticas, Ciencias; Trabajo en equipo, Individual', 30),
    ('Prueba de Intereses Profesionales', 'Identifica los intereses que se alinean con diferentes carreras.', 'Intereses', '1. ¿Te gusta trabajar con personas?; 2. ¿Prefieres el trabajo al aire libre?', 'Sí, No', 45),
    ('Prueba de Habilidades', 'Evalúa las habilidades prácticas y técnicas del estudiante.', 'Habilidades', '1. ¿Qué tan bien resuelves problemas?; 2. ¿Eres bueno con herramientas?', 'Muy bien, No estoy seguro', 20),
    ('Prueba de Estilos de Aprendizaje', 'Determina el estilo de aprendizaje más efectivo para el estudiante.', 'Estilo de Aprendizaje', '1. ¿Aprendes mejor leyendo?; 2. ¿Prefieres aprender con ejemplos?', 'Sí, Sí', 25),
    ('Prueba de Aptitudes', 'Evalúa las aptitudes generales y específicas del estudiante.', 'Aptitudes', '1. ¿Cómo evalúas tu habilidad para aprender nuevas tecnologías?; 2. ¿Te resulta fácil aprender idiomas?', 'Alta, Media', 30);

INSERT INTO resultado_pruebas (resultado, recomendaciones, feedback)
VALUES
    ('Alta orientación hacia ciencias exactas', 'Considera una carrera en ingeniería o matemáticas.', 'Buen desempeño en matemáticas y lógica.'),
    ('Intereses en humanidades', 'Explora carreras en psicología o educación.', 'Interés notable en temas sociales y literarios.'),
    ('Habilidades en tecnología', 'Carreras recomendadas en informática o diseño gráfico.', 'Muestra gran afinidad por las tecnologías digitales.'),
    ('Preferencia por trabajos en equipo', 'Podrías considerar administración de empresas o recursos humanos.', 'Buen trabajo colaborativo, habilidades interpersonales.'),
    ('Talento para resolver problemas prácticos', 'Carreras en ingeniería mecánica o arquitectura.', 'Excelente capacidad para pensar de manera crítica y creativa.');
