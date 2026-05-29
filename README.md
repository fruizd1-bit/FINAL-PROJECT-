# Campus Lite UMG

Sistema de gestión académica desarrollado en Java utilizando Programación Orientada a Objetos y Swing.

## Integrantes
- Fredy Eduardo Ruiz Duran
- Kervin Saúl García Rodriguez
- Edward Meyer Natareno García 

---

# Descripción

El sistema permite administrar estudiantes, cursos y evaluaciones desde una interfaz gráfica desarrollada con Swing.

El proyecto fue desarrollado aplicando conceptos de:
- Programación Orientada a Objetos
- Herencia
- Polimorfismo
- Encapsulamiento
- Persistencia de datos
- Interfaces gráficas con Swing

---

# Funcionalidades

## Gestión de estudiantes
- Agregar estudiantes
- Buscar estudiantes
- Editar estudiantes
- Eliminar estudiantes

## Gestión de cursos
- Asignar cursos a estudiantes
- Visualizar cursos asignados
- Editar cursos
- eliminar cursos
- regresar a mainframe

## Gestión de evaluaciones
- Agregar evaluaciones
- Editar evaluaciones
- Eliminar evaluaciones
- Mostrar evaluaciones
- regresar a courseform

## Reportes
- Calcular nota final
- Mostrar estado aprobado/reprobado
- mostrar estudiante
- mostrar curso

---

# Tecnologías utilizadas

- Java
- Eclipse IDE
- Swing

---

# Conceptos POO implementados

## Herencia
La clase `Evaluation` funciona como clase padre de:
- `WrittenExam`
- `LabEvaluation`
- `ProjectEvaluation`

## Polimorfismo
Se utilizaron referencias de tipo `Evaluation` para manejar diferentes tipos de evaluaciones.

## Encapsulamiento
Los atributos fueron declarados privados y manipulados mediante getters y setters.

---

# Persistencia de datos

El sistema utiliza `FileManager` para guardar y cargar información automáticamente.

---

# Interfaz gráfica

El sistema está compuesto por:
- MainFrame
- StudentForm
- CourseForm
- EvaluationForm
- ReportForm

---

# Ejecución

1. Clonar el repositorio
2. importar el proyecto a su IDE
3. localizar el paquete ui
4. abrir la clase MainFrame
5. ejecutar la clase MainFrame
