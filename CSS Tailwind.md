CSS makes html look good it handles colors layouts fonts

CSS SYNTAX:
selector { property: value; }
p { color: blue; font-size: 16px; }

WAYS TO ADD CSS:
inline in style attribute:
<p style="color: blue;">blue text</p>

internal in style tag:
<style> p { color: blue; } </style>

external in .css file:
<link rel="stylesheet" href="styles.css">

SELECTORS:
element p { }
class .className { }
id #idName { }
universal * { }

BOX MODEL:
content padding border margin
width height control content size
padding space inside border
border around padding  
margin space outside border

DISPLAY PROPERTY:
block takes full width div p h1
inline takes only needed width span a
inline-block like inline but with width/height
none completely hidden

POSITIONING:
static normal flow
relative offset from normal position
absolute relative to nearest positioned ancestor
fixed relative to viewport
sticky like fixed after scrolling

FLEXBOX one-dimensional layouts:
.container { display: flex; }
justify-content aligns horizontally
align-items aligns vertically
flex-direction row or column

GRID two-dimensional layouts:
.container { display: grid; grid-template-columns: 1fr 1fr; }
grid-template-rows defines row sizes
gap space between grid items

COLORS:
color: red;
color: #ff0000;
color: rgb(255, 0, 0);
color: rgba(255, 0, 0, 0.5); with transparency

FONTS AND TEXT:
font-family: Arial, sans-serif;
font-size: 16px;
font-weight: bold;
text-align: center;
line-height: 1.5;

BACKGROUND:
background-color: white;
background-image: url('image.jpg');
background-size: cover;
background-position: center;

ANIMATIONS:
transition: all 0.3s ease;
animation: slide 1s infinite;
@keyframes slide { from { opacity: 0; } to { opacity: 1; } }

RESPONSIVE DESIGN:
@media (max-width: 768px) { .container { flex-direction: column; } }

TAILWIND CSS utility-first framework:
use predefined classes instead of custom css

EXAMPLE:
<div class="bg-blue-500 text-white p-4 rounded-lg">
styled div with tailwind
</div>

TAILWIND COLORS:
bg-color-shade for backgrounds
text-color-shade for text  
border-color-shade for borders

TAILWIND SPACING:
p-4 padding 1rem
m-4 margin 1rem
mx-4 horizontal margin
my-4 vertical margin

TAILWIND FLEXBOX AND GRID:
flex flex-col flex-row
justify-center justify-between
items-center items-start
grid grid-cols-3 gap-4

TAILWIND RESPONSIVE:
sm: md: lg: xl: 2xl: prefixes
<div class="w-full md:w-1/2">full width mobile half desktop</div>

TAILWIND STATES:
hover:bg-blue-700 focus:outline-none

VEHICLE CARD EXAMPLE:
<div class="bg-white rounded-lg shadow-md p-6 hover:shadow-lg transition-shadow">
<h3 class="text-xl font-bold text-gray-800">Toyota Corolla</h3>
<p class="text-green-600 font-semibold">$15,000</p>
<button class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600">
View Details
</button>
</div>