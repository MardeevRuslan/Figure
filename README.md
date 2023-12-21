# Figure
## Это консольное приложение, написанное на Java 8, которое реалиует описание фигур.
## Поддерживаемые фигуры:
- Point
- Line
- Circle
- Rect
## Для сохранения фигур используется файл с расширением .txt src/main/resources/CreateFigure.txt
## Пример ввода:
```
point 1 2
rect 1 2 3 4
line 10 10 20 20
circle 10 10 5
```

## Поддерживаемые записи во входном файле:
```
роint x y — точка в координатах (x, y)
rеct x1 y1 x2 y2 — прямоугольник, заданный точками (x1, y1) и (x2, y2)
linе x1 x2 x2 y2 — линия, заданная точками (x1, y1) и (x2, y2)
сirclе x y r — круг с центром в (x, y) и радиусом r
```

## Пример вывода Draw:
```
роint at (10, 20)
circle at (-100, 300), rаdius = 50
rect at (100, 200), (200, 300)
```

## Пример вывода Intersect:

#### Пересечение в одной точке:
```
Thе rect and the point intersect at  1 point(s)  (1.0 , 2.0 )
```
#### Пересечение в нескольких точках:
```
Thе rect and the rect intersect at  2 point(s)  (5.0 , 2.0 )  (2.0 , 5.0 )
```
#### Нет пересечения:
```
Thе rect cannot intersect the rect
```
#### Один из отрезков фигуры входит в другой:
```
An infinite number of intersection points
```
#### Фигуры одинаковые:
```
The Circle and the Circle match
```

## Установка и использование приложения:
#### Скачать:
```
git clone https://github.com/MardeevRuslan/Figure.git
```
#### Перейти в корневую директорию:
```
cd Figure
```
#### Запустить через Makefile:
```
make all
```
#### Или Maven:
```
mvn -f pom.xml package
```
```
java -jar target/Figure-1.0-jar-with-dependencies.jar
```
#### Или можете скачать уже собранный jar-файл в архиве zip:

```
https://disk.yandex.ru/d/KJPgQ04xLmlbVw
```

#### Распаковать архив, перейти в корневую директорию и запустить:
```
cd Figure-1.0
```
```
java -jar Figure-1.0-jar-with-dependencies.jar
```
