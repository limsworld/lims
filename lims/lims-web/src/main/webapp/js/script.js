// must be loaded at the end of the body element
(function(){
	var addEvent = function(element, event, func){
			if(element.addEventListener){
				element.addEventListener(event, func, false);
			}
			else{
				element.attachEvent('on'+event, func);
			}
		},
		eventPreventDefault = function(event){
			event = event || window.event;
			if(event.preventDefault){
				event.preventDefault();
			}
			else{
				event.returnValue = false;
			}
		},
		navMainMobile = document.getElementById('nav-main-mobile'),
		navMain = document.getElementById('nav-main'),
		navMainLis, i, element, navMainTouched,
		navSearch = document.getElementById('nav-search');
	if(navMainMobile){
		addEvent(navMainMobile, 'change', function(){
			document.location.href = navMainMobile.value;
		});
	}
	if(navSearch){
		addEvent(navSearch.getElementsByTagName('input')[0], 'focus', function(){
			navSearch.className = 'focus';
		});
		addEvent(navSearch.getElementsByTagName('button')[0], 'focus', function(){
			navSearch.className = 'focus';
		});
		addEvent(navSearch.getElementsByTagName('input')[0], 'blur', function(){
			navSearch.className = '';
		});
		addEvent(navSearch.getElementsByTagName('button')[0], 'blur', function(){
			navSearch.className = '';
		});
	}
	// dropdown fix for all touch devices except iOS
	if(window.Modernizr && Modernizr.touch && !navigator.userAgent.match(/(iPad|iPhone|iPod)/i)){
		if(navMain && navMain.getElementsByTagName('ul').length){
			navMainLis = navMain.getElementsByTagName('ul')[0].childNodes;
			for(i = 0; i < navMainLis.length; i++){
				if(navMainLis[i].nodeName && navMainLis[i].nodeName.toLowerCase() === 'li' && navMainLis[i].getElementsByTagName('ul').length){
					element = navMainLis[i].getElementsByTagName('a');
					if(element && (element = element[0])){
						addEvent(element, 'click', function(event){
							if(navMainTouched !== this){
								navMainTouched = this;
								eventPreventDefault(event);
							}
						});
					}
				}
			}
		}
	}
})();

// IE8 icon font bug (http://stackoverflow.com/a/10557782)
if(document.documentElement.className.indexOf('lt-ie9') !== -1){
	(function(){
		var head = document.getElementsByTagName('head')[0],
		    style = document.createElement('style');
		style.type = 'text/css';
		style.styleSheet.cssText = ':before,:after{content:none !important';
		head.appendChild(style);
		setTimeout(function(){
			head.removeChild(style);
		}, 0);
	})();
}
