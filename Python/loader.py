import instaloader
from instaloader import Post
from instaloader.structures import Profile

L = instaloader.Instaloader()

#Get shortcode from link
link = input("Link: ")
s = link.split('/')
shortcode = s[4]
print(shortcode)

#Login
L.login("m_megyesi", "M3gy3s1INSTA")

#Post
post = Post.from_shortcode(L.context, shortcode)
L.download_post(post, "01")

#Profile
#prof = Profile.from_username(L.context, 'NAME')
#L.download_profilepic(profile)
#L.download_profilepic(prof);

#Full Profile Download
#L.download_profile(profile_name='', profile_pic=False)