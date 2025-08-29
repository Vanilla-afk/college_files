import pygame
import time
import random

# Initialize pygame
pygame.init()

# Screen dimensions
width = 600
height = 400

# Colors
white = (255, 255, 255)
black = (0, 0, 0)
red = (213, 50, 80)
green = (0, 255, 0)
blue = (50, 153, 213)

# Snake block size and speed
snake_block = 10
snake_speed = 15

# Font styles
font_style = pygame.font.SysFont("bahnschrift", 25)
score_font = pygame.font.SysFont("comicsansms", 35)

# Create display
dis = pygame.display.set_mode((width, height))
pygame.display.set_caption("Snake Game 🐍")

clock = pygame.time.Clock()


def score_display(score):
    """Display current score"""
    value = score_font.render("Score: " + str(score), True, black)
    dis.blit(value, [10, 10])


def snake(snake_block, snake_list):
    """Draw snake on screen"""
    for x in snake_list:
        pygame.draw.rect(dis, green, [x[0], x[1], snake_block, snake_block])


def message(msg, color):
    """Display message"""
    mesg = font_style.render(msg, True, color)
    dis.blit(mesg, [width / 6, height / 3])


def game_loop():
    # Starting position
    game_over = False
    game_close = False

    x1 = width / 2
    y1 = height / 2

    # Movement
    x1_change = 0
    y1_change = 0

    # Snake body
    snake_list = []
    length_of_snake = 1

    # Food position
    foodx = round(random.randrange(0, width - snake_block) / 10.0) * 10.0
    foody = round(random.randrange(0, height - snake_block) / 10.0) * 10.0

    while not game_over:

        while game_close:
            dis.fill(blue)
            message("You Lost! Press C-Play Again or Q-Quit", red)
            score_display(length_of_snake - 1)
            pygame.display.update()

            # Restart or Quit
            for event in pygame.event.get():
                if event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_q:
                        game_over = True
                        game_close = False
                    if event.key == pygame.K_c:
                        game_loop()

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                game_over = True
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_LEFT and x1_change == 0:
                    x1_change = -snake_block
                    y1_change = 0
                elif event.key == pygame.K_RIGHT and x1_change == 0:
                    x1_change = snake_block
                    y1_change = 0
                elif event.key == pygame.K_UP and y1_change == 0:
                    y1_change = -snake_block
                    x1_change = 0
                elif event.key == pygame.K_DOWN and y1_change == 0:
                    y1_change = snake_block
                    x1_change = 0

        # Borders
        if x1 >= width or x1 < 0 or y1 >= height or y1 < 0:
            game_close = True

        # Update position
        x1 += x1_change
        y1 += y1_change
        dis.fill(blue)
        pygame.draw.rect(dis, red, [foodx, foody, snake_block, snake_block])

        # Snake growing
        snake_head = [x1, y1]
        snake_list.append(snake_head)
        if len(snake_list) > length_of_snake:
            del snake_list[0]

        # Collision with itself
        for segment in snake_list[:-1]:
            if segment == snake_head:
                game_close = True

        snake(snake_block, snake_list)
        score_display(length_of_snake - 1)

        pygame.display.update()

        # Eat food
        if x1 == foodx and y1 == foody:
            foodx = round(random.randrange(0, width - snake_block) / 10.0) * 10.0
            foody = round(random.randrange(0, height - snake_block) / 10.0) * 10.0
            length_of_snake += 1

        clock.tick(snake_speed)

    pygame.quit()
    quit()


# Run the game
game_loop()
