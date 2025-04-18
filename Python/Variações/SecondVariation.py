import math
import random
import matplotlib.pyplot as plt

# Calculates the distance between two points
def distance(x1, x2, y1, y2):
    dx = x1 - x2
    dy = y1 - y2
    return math.sqrt(dx * dx + dy * dy)

# Calculates the fixed side of the triangle (distance between two defined angles)
def triangle_side(a, b, radius, centerX, centerY):
    x1 = math.cos(math.radians(a)) * radius + centerX
    y1 = math.sin(math.radians(a)) * radius + centerY

    x2 = math.cos(math.radians(b)) * radius + centerX
    y2 = math.sin(math.radians(b)) * radius + centerY

    return distance(x1, x2, y1, y2)

# Second variation: selects a random point uniformly within the circle
def simulate_paradox_2(total=1000000):
    # Circle parameters
    centerX = 200
    centerY = 200
    radius = 100
    count = 0

    for _ in range(total):
        # Fixed triangle side (between 90° and 210°)
        side = triangle_side(90, 210, radius, centerX, centerY)

        # Random angle and uniform distance from center
        angle = random.uniform(0, 360)
        dist_from_center = random.uniform(0, radius)

        # Calculate midpoint of the chord
        midX = math.cos(math.radians(angle)) * dist_from_center + centerX
        midY = math.sin(math.radians(angle)) * dist_from_center + centerY

        # Calculate half length of the chord using Pythagoras
        half_chord = math.sqrt(radius * radius - dist_from_center * dist_from_center)

        # Get perpendicular direction for the chord
        perp_angle = angle + 90

        # Calculate the endpoints of the chord
        q1X = math.cos(math.radians(perp_angle)) * half_chord + midX
        q1Y = math.sin(math.radians(perp_angle)) * half_chord + midY

        q2X = math.cos(math.radians(perp_angle + 180)) * half_chord + midX
        q2Y = math.sin(math.radians(perp_angle + 180)) * half_chord + midY

        # Compute chord length
        chord = distance(q1X, q2X, q1Y, q2Y)

        # Count if the chord is greater than or equal to the triangle side
        if chord >= side:
            count += 1

    return count, total

# Plot the results as a bar graph
def plot_results(count, total, variation_number):
    greater = count
    lesser = total - count
    pct_greater = (greater / total) * 100
    pct_lesser = (lesser / total) * 100

    labels = ['Chord > Side', 'Chord ≤ Side']
    values = [pct_greater, pct_lesser]
    colors = ['#66c2a5', '#fc8d62']

    plt.figure(figsize=(8, 6))
    bars = plt.bar(labels, values, color=colors)
    plt.ylim(0, 100)
    plt.ylabel('Percentage (%)')
    plt.title(f'Bertrand Paradox – Variation {variation_number} – {total:,} simulations')

    for bar, value in zip(bars, values):
        plt.text(
            bar.get_x() + bar.get_width() / 2,
            value + 1,
            f'{value:.2f}%',
            ha='center', va='bottom', fontsize=12
        )

    plt.grid(axis='y', linestyle='--', alpha=0.6)
    plt.tight_layout()
    plt.show()

# Run 2nd variation
count2, total2 = simulate_paradox_2()
plot_results(count2, total2, variation_number=2)
