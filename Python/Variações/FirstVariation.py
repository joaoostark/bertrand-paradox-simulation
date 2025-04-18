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

def simulate_paradox_1(total=1000000):
    # Circle parameters
    centerX, centerY = 200, 200
    radius = 100
    count = 0

    for _ in range(total):
        # Fixed side of the triangle (set between 90° and 210° as in the original)
        side = triangle_side(90, 210, radius, centerX, centerY)
        # Generates two random angles in degrees
        angle1 = random.uniform(0, 360)
        angle2 = random.uniform(0, 360)
        # Convert to radians
        x1 = math.cos(math.radians(angle1)) * radius + centerX
        y1 = math.sin(math.radians(angle1)) * radius + centerY

        x2 = math.cos(math.radians(angle2)) * radius + centerX
        y2 = math.sin(math.radians(angle2)) * radius + centerY
        # Calcula o comprimento da corda
        chord = distance(x1, x2, y1, y2)
        # Verifica se a corda é maior que o lado fixo
        if chord >= side:
            count += 1

    return count, total
# Generate the results graph
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

# Run 1st variation
count1, total1 = simulate_paradox_1()
plot_results(count1, total1, variation_number=1)
