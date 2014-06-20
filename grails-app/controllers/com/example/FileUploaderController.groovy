package com.example

class FileUploaderController {

    def index() {
        def f = request.getFile('2014-03-28')
        println f.bytes
        if (f.empty) {
            flash.message = 'file cannot be empty'
            render(view: 'uploadForm')
            return
        }
        f.transferTo(new File('C:\\tools\\temp\\myFile.pdf'))
        response.sendStatus(200, 'Done')
        render "ok"
    }
}
