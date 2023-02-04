import pygame


WINDOW_HEIGHT = 1080
WINDOW_WIDTH = 1920

WINDOW_RESIZE = False
CAMERA_ACTIVE = False

pygame.init()
WORLD_IMAGE = pygame.image.load("worldmap.png")
pygame.display.set_caption("World Map Interactive")
INITAL_IMAGE_POSITION = (0, 0)
coordXChange = 0
coordYChange = 0
BACKGROUND_COLOR = (255, 255, 255)

canvas = pygame.display.set_mode((WINDOW_WIDTH, WINDOW_HEIGHT))
playedHold = False

while True:
	canvas.fill(BACKGROUND_COLOR)
	canvas.blit(WORLD_IMAGE, dest = (INITAL_IMAGE_POSITION[0] + coordXChange, INITAL_IMAGE_POSITION[1] + coordYChange))
	for event in pygame.event.get():
		if event.type == pygame.QUIT:
			break
		if event.type == pygame.MOUSEBUTTONDOWN:
			userButtonPressed = True
			coordinates = pygame.mouse.get_pos()
			print("Current mouse coordinates: " + str(coordinates))
			if ((coordXChange - coordinates[0] - WINDOW_WIDTH / 2) > -5000):
				coordXChange -= coordinates[0] - WINDOW_WIDTH / 2
				print("Current coordX change: " + str(coordXChange))
			if ((coordYChange - coordinates[1] - WINDOW_HEIGHT / 2) > -3000):
				coordYChange -= coordinates[1] - WINDOW_HEIGHT / 2
				print("Current coordY change: " + str(coordYChange))


	pygame.display.update()
