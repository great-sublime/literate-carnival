HTML is the skeleton of web pages it defines structure not design
HTML uses tags to mark up content
tags come in pairs like opening and closing tags

BASIC STRUCTURE:
<!DOCTYPE html>
<html>
<head>
<title>page title appears in browser tab</title>
</head>
<body>
all visible content goes here
</body>
</html>

COMMON TAGS:
<h1>main title</h1>
<h2>section headings</h2>
<p>paragraphs of text</p>
<div>container for grouping elements</div>
<form>for user input forms</form>
<input>for text numbers dates</input>
<button>clickable buttons</button>
<img>to display images</img>
<a>links to other pages</a>
<ul>unordered lists</ul>
<ol>ordered lists</ol>
<li>list items</li>
<table>for displaying data tables</table>
<span>inline container for text</span>
<br>line break</br>
<hr>horizontal line</hr>

ATTRIBUTES:
class for css styling 
id for javascript access
src for image sources 
href for link destinations
alt for image descriptions
required for mandatory form fields
placeholder for input hints
data-* for custom data storage

VEHICLE PLATFORM EXAMPLES:

Vehicle listing card:
<div class="vehicle-card" id="car-123">
<h3>Toyota Corolla 2020</h3>
<img src="car.jpg" alt="blue toyota corolla">
<p class="price">$15000</p>
<button class="contact-btn">Contact Seller</button>
</div>

Search form:
<form id="search-form">
<input type="text" name="make" placeholder="Car make" required>
<input type="text" name="model" placeholder="Car model">
<input type="number" name="max-price" placeholder="Max price">
<button type="submit">Search Vehicles</button>
</form>

SEMANTIC TAGS for better structure:
<header>page header</header>
<nav>navigation menu</nav>
<main>main content</main>
<section>content sections</section>
<article>self-contained content</article>
<aside>sidebar content</aside>
<footer>page footer</footer>

HTML5 INPUT TYPES:
<input type="email"> for email addresses
<input type="tel"> for phone numbers  
<input type="number"> for numbers
<input type="date"> for dates
<input type="file"> for file uploads
<input type="range"> for sliders
<input type="color"> for color pickers

SPECIAL CHARACTERS:
&amp; for & 
&lt; for <
&gt; for >
&nbsp; for non-breaking space
&copy; for copyright