cd src

java -cp "lib/colt-1.0.3.jar;." BuildEigenFaces

java -cp "lib/colt-1.0.3.jar;" FaceRecognition test.png
exit