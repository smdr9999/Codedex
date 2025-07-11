import imageio.v3 as iio
from PIL import Image
import numpy as np

filenames = ['chicklet1.png', 'chicklet2.png','chicklet3.png','chicklet4.png']
images = []

base_image=Image.open(filenames[0])
base_size=base_image.size
images.append(np.array(base_image))

for filename in filenames[1:]:
  img=Image.open(filename).resize(base_size)
  images.append(np.array(img))

iio.imwrite('chicklet.gif', images, duration = 500, loop = 0)
