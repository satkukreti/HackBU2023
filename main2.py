from tkinter import *
import tkintermapview

root = Tk()
root.title("Map test")
maxWidth = root.winfo_screenwidth()
maxHeight = root.winfo_screenheight()

print("Max Width: " + str(maxWidth))
root.geometry(f'{maxWidth}x{maxHeight}')

label = LabelFrame(root)
label.pack(pady=20)
worldMatrix = []
map_widget = tkintermapview.TkinterMapView(label, width=maxWidth, height=maxHeight)
map_widget.pack()
map_widget.set_tile_server(
    "http://c.tile.stamen.com/watercolor/{z}/{x}/{y}.png")

root.mainloop()