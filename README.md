# Converter_EUR--CNY
Конвертер валют из евро в юани и обратно.

Запуск в докере:
-----------

```
docker build -t converter .
docker run -it --rm -p 9001:9001 converter   
```

Как пользоваться:
-----------
`EURtoCNY` - конвертировать из евро в юань.
```
http://localhost:9001/converter/convert/EURtoCNY/{valueHere}
```
`CNYtoEUR` — конвертировать из юаней в евро.
```
http://localhost:9001/converter/convert/CNYtoEUR/{valueHere}
```

main:
![Tests](https://github.com/Volochkovskaya/Converter_EUR--CNY/actions/workflows/gradle-test.yml/badge.svg?branch=main)
dev:
![Tests](https://github.com/Volochkovskaya/Converter_EUR--CNY/actions/workflows/gradle-test.yml/badge.svg?branch=dev)