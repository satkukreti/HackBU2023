import cv2

originalImage = cv2.imread("image.png")

grayImage = cv2.cvtColor(originalImage, cv2.COLOR_BGR2GRAY)