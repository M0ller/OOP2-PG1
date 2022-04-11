function changeRoute(){    
    let page =  location.hash.replace('#','')
    if(!page){
        page = 'firstpage'
    }
    // vi kollar först om det finns en registrerad page (annars, 404)
    if(!pages[page]){
        console.log('would render a 404')
        return
    }
    // vi undersöker hashen pages om vi har en instans eller en klass, 
    // har vi en klass men ingen instans, ersätter vi klassen med dess instans
    
    // vår "page" är först en klass, första gången changeRoute körs
    if(pages[page].constructor.name === 'Function'){

        // men vi vill ju ha en instans
        pages[page] = new pages[page]
    
        // registrera samtidigt eventuella delegated event handlers
    
        if(pages[page].events){
            pages[page].events() 
        }
    }
    
    // vi använder instansen
    pages[page].render()
}