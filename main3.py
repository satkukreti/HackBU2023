from rendascii.interface import Engine as REngine

res_dir = 'resources/'
r_eng = REngine(
    colormap_dir=res_dir + 'colormaps/',
    sprite_dir=res_dir + 'sprites/',
    model_dir=res_dir + 'models/',
    material_dir=res_dir + 'models/',
    num_workers=4
)
