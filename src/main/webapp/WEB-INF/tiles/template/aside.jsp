<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<aside>
	<h2>Search</h2>
	<div>
		<input type="text" id="searchbox"
			onBlur="if (this.value == '') {this.value = 'search...';}"
			onFocus="if (this.value == 'search...') {this.value = '';}"
			value="search..." name="s" /> <input id="searchbutton" type="submit"
			value=" " />
	</div>
	<h2>Categories</h2>
	<ul>
		<li>
			<div class="bubbleInfo">
				<a href="#" class="trigger">Articles</a>
				<p class="popup">Just some web related stuff.</p>
			</div>
		</li>
		<li>
			<div class="bubbleInfo">
				<a href="#" class="trigger">Freebies</a>
				<p class="popup">Everything we want to give away, it is free go
					on take it.</p>
			</div>
		</li>
		<li>
			<div class="bubbleInfo">
				<a href="#" class="trigger">Personal</a>
				<p class="popup">All our site updates and personal interests.</p>
			</div>
		</li>
		<li>
			<div class="bubbleInfo">
				<a href="#" class="trigger">Resources</a>
				<p class="popup">Tools, Fonts, Plug-ins, Add-ons, Downloads, and
					more.</p>
			</div>
		</li>
		<li>
			<div class="bubbleInfo">
				<a href="#" class="trigger">Tutorials</a>
				<p class="popup">Learn from our tutorials, tricks, tips, and
					more.</p>
			</div>
		</li>
	</ul>
	<h2>Popular Posts</h2>
	<ul>
		<li>
			<div class="bubbleInfo">
				<a href="#" class="trigger">Horizontal Nav with CSS</a>
				<p class="popup">This is a post with 4 comments.</p>
			</div>
		</li>
		<li>
			<div class="bubbleInfo">
				<a href="#" class="trigger">3 Column Footer with CSS</a>
				<p class="popup">This is a post with 6 comments.</p>
			</div>
		</li>
		<li>
			<div class="bubbleInfo">
				<a href="#" class="trigger">Popular Post goes here</a>
				<p class="popup">This is a post with 8 comments.</p>
			</div>
		</li>
		<li>
			<div class="bubbleInfo">
				<a href="#" class="trigger">Popular Post goes here</a>
				<p class="popup">This is a post with 8 comments.</p>
			</div>
		</li>
		<li>
			<div class="bubbleInfo">
				<a href="#" class="trigger">Popular Post goes here</a>
				<p class="popup">This is a post with 8 comments.</p>
			</div>
		</li>
	</ul>
	<h2>Recent Comments</h2>
	<ul class="recent-comment">
		<li>
			<div class="bubbleInfo">
				<a href="#"><img src="images/avatar.gif"></a> <a href="#"
					class="trigger">Horizontal Nav with CSS</a> <span class="commenter">-
					Thomas Larangeira @ Sept 10, 2010</span>
				<p class="popup">"This is one of the most recent comments to a
					post"</p>
			</div>
		</li>
		<li>
			<div class="bubbleInfo">
				<a href="#"><img src="images/avatar.gif"></a> <a href="#"
					class="trigger">Horizontal Nav with CSS</a> <span class="commenter">-
					Thomas Larangeira @ Sept 10, 2010</span>
				<p class="popup">"This is one of the most recent comments to a
					post"</p>
			</div>
		</li>
		<li>
			<div class="bubbleInfo">
				<a href="#"><img src="images/avatar.gif"></a> <a href="#"
					class="trigger">Horizontal Nav with CSS</a> <span class="commenter">-
					Thomas Larangeira @ Sept 10, 2010</span>
				<p class="popup">"This is one of the most recent comments to a
					post"</p>
			</div>
		</li>
		<li>
			<div class="bubbleInfo">
				<a href="#"><img src="images/avatar.gif"></a> <a href="#"
					class="trigger">Horizontal Nav with CSS</a> <span class="commenter">-
					Thomas Larangeira @ Sept 10, 2010</span>
				<p class="popup">"This is one of the most recent comments to a
					post"</p>
			</div>
		</li>
		<li>
			<div class="bubbleInfo">
				<a href="#"><img src="images/avatar.gif"></a> <a href="#"
					class="trigger">Horizontal Nav with CSS</a> <span class="commenter">-
					Thomas Larangeira @ Sept 10, 2010</span>
				<p class="popup">"This is one of the most recent comments to a
					post"</p>
			</div>
		</li>
	</ul>
</aside>
<!-- End Aside !-->

