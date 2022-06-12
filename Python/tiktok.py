import requests
import shutil

def download_file(url):
    local_filename = url.split('/')[-1]
    with requests.get(url, stream=True) as r:
        with open(local_filename, 'wb') as f:
            shutil.copyfileobj(r.raw, f)

    return local_filename

download_file('https://v16-web.tiktok.com/video/tos/useast2a/tos-useast2a-ve-0068c003/6613ab5e23e1428494f62254e3da1759/?a=1988&br=2534&bt=1267&cd=0%7C0%7C1&ch=0&cr=0&cs=0&cv=1&dr=0&ds=3&er=&expire=1633111126&ft=9wMeRe9G4kag3&l=20211001115829010189066041542C95AA&lr=tiktok_m&mime_type=video_mp4&net=0&pl=0&policy=3&qs=0&rc=ajZxOzg6ZjdxNzMzNzczM0ApOTVoaTgzaTw7NzdlMzU2PGcyci41cjRfYW1gLS1kMTZzczBfXjIuNV8tMWBeNjY0MjM6Yw%3D%3D&signature=222e590afe0c954d2789074da013e8fc&tk=6818222027247567877&vl=&vr=')