-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 06, 2021 at 08:54 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `movie`
--

-- --------------------------------------------------------

--
-- Table structure for table `advertisement`
--

CREATE TABLE `advertisement` (
  `id` int(11) NOT NULL,
  `banner` varchar(255) DEFAULT NULL,
  `cooperation_company` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `end_at` datetime DEFAULT NULL,
  `location` int(11) NOT NULL,
  `status` bit(1) NOT NULL,
  `access` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `advertisement`
--

INSERT INTO `advertisement` (`id`, `banner`, `cooperation_company`, `created_at`, `end_at`, `location`, `status`, `access`) VALUES
(1, 'https://thumbs.gfycat.com/UnknownElaborateCanadagoose-size_restricted.gif', 'Google', '2021-09-10 23:32:00', '2021-09-30 15:32:00', 1, b'1', 'https://animehay.site/'),
(2, 'https://i.pinimg.com/originals/fb/7e/7f/fb7e7f18eeba5df417809e9db8c683bf.gif', 'Facebook', '2021-09-08 23:40:00', '2021-09-15 12:43:00', 2, b'1', 'https://anime47.com/'),
(3, '/img/ads.mp4', 'Google', '2021-09-10 23:42:00', '2021-09-30 14:45:00', 4, b'1', 'https://www.google.com/?hl=vi'),
(4, 'Nija', 'Youtobe', '2021-09-16 00:59:00', '2021-09-23 05:57:00', 3, b'1', 'https://www.youtube.com/watch?v=pTIN6-pLeds&t=3416s&ab_channel=MagicMusic'),
(5, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQdh3DFHgcesu_by99S2cuNk6R8KFBWk0z3i-L-YZH5C_VjVsDIkgK8gQL5LtJcsOyCbg&usqp=CAU', 'Facebook', '2021-08-30 01:05:00', '2021-10-07 01:05:00', 2, b'0', 'https://gfycat.com/gifs/search/banner+vertical');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `category_name`, `status`) VALUES
(1, 'Action', b'1'),
(2, 'Horror', b'1'),
(3, 'History', b'1'),
(4, 'Humor', b'1'),
(5, 'School', b'1'),
(6, 'Ver 18+', b'1'),
(7, 'Anime', b'1'),
(8, 'CM Animation', b'1'),
(9, 'Live Action', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `category_detail`
--

CREATE TABLE `category_detail` (
  `category_id` int(11) NOT NULL,
  `movie_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category_detail`
--

INSERT INTO `category_detail` (`category_id`, `movie_id`) VALUES
(5, 6),
(7, 6),
(1, 1),
(2, 1),
(1, 9),
(4, 2),
(9, 2),
(1, 3),
(3, 3),
(9, 3),
(2, 4),
(8, 4),
(9, 4),
(2, 5),
(3, 5),
(9, 5),
(4, 21),
(8, 21),
(9, 21),
(3, 7),
(6, 7),
(9, 7);

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`id`, `comment`, `create_at`, `status`, `username`, `user_id`) VALUES
(1, 'What\'s your name ?', '2021-09-07 16:02:26', b'1', 'Hoang', 1),
(2, 'How old are you?', '2021-09-07 18:02:26', b'1', 'Ha', 1),
(3, 'Hello, Phan Anh', '2021-09-08 06:00:44', b'1', 'Hoa', 1),
(4, 'Hello, Phan Anh', '2021-09-08 06:00:44', b'1', 'Hsoa', 1),
(5, 'Wtf', '2021-09-08 06:03:27', b'1', 'Huy Anh', 1),
(6, 'Darling', '2021-09-08 12:42:19', b'1', 'Phan', 1),
(7, 'Haha', '2021-09-08 12:57:06', b'1', 'nguyễn', 1),
(8, 'Ek', '2021-09-08 13:00:12', b'1', 'Haha', 1),
(9, 'Eks', '2021-09-08 13:00:12', b'1', 'Haha', 1),
(10, 'Heelo world', '2021-09-08 13:00:12', b'1', 'Phan Anh Hoang', 1),
(12, 'Haoaoao', '2021-09-08 21:23:32', b'1', 'helo', 1),
(13, '15', '2021-09-08 22:46:15', b'1', 'phan', 1),
(14, '13', '2021-09-08 22:46:58', b'1', 'hoa', 1),
(15, '1', '2021-09-08 22:49:10', b'1', 'phan', 1),
(16, '45', '2021-09-08 22:50:22', b'1', 'phan', 1),
(17, 'Hello', '2021-09-08 22:54:39', b'1', 'Kevin', 1),
(18, 'How are tou', '2021-09-08 22:54:47', b'1', 'Kevin', 1),
(19, 'Huy', '2021-09-08 22:56:28', b'1', 'Halo', 1),
(20, '12', '2021-09-08 23:03:35', b'1', 'Halo', 1),
(21, 'lo', '2021-09-08 23:04:07', b'1', 'Huy', 3),
(22, 'lo', '2021-09-08 23:04:11', b'1', 'Halo', 1),
(23, 'Chào thế giới', '2021-09-08 23:14:55', b'1', 'Phan', 2),
(24, 'Chào c !', '2021-09-08 23:15:03', b'1', 'Anh', 3),
(25, 'Ani', '2021-09-10 20:55:15', b'1', 'Kevin', 1),
(26, 'Haha', '2021-09-10 20:56:27', b'1', 'Anh', 1),
(28, 'Chào', '2021-09-17 21:53:06', b'1', 'Nakai', 6),
(29, '123', '2021-09-18 19:52:50', b'1', 'Hami', 1),
(30, 'hello', '2021-09-18 19:53:11', b'1', 'Nakai', 6),
(31, 'Hello', '2021-09-18 20:06:46', b'1', 'Hoang', 1),
(32, 'Hoang', '2021-09-19 12:56:16', b'1', 'Nakai', 11),
(33, 'ha', '2021-09-19 12:56:30', b'1', 'HUy', 6),
(34, 'hoang', '2021-09-19 14:18:54', b'1', 'Nakai', 11),
(35, 'Hello world', '2021-09-19 14:19:41', b'1', 'Nakai', 11),
(36, 'hoang', '2021-09-19 14:20:15', b'1', 'hoang', 6);

-- --------------------------------------------------------

--
-- Table structure for table `episode`
--

CREATE TABLE `episode` (
  `id` int(11) NOT NULL,
  `episode_name` varchar(255) DEFAULT NULL,
  `episode_view` int(11) NOT NULL,
  `status` bit(1) NOT NULL,
  `movie_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `episode`
--

INSERT INTO `episode` (`id`, `episode_name`, `episode_view`, `status`, `movie_id`) VALUES
(1, 'HD-Vietsub', 138, b'1', 1),
(2, 'HD-Vietsub', 1055, b'1', 2),
(3, 'Episode 1', 1631, b'1', 3),
(4, 'Episode 2', 232, b'1', 3),
(5, 'Episode 3', 211, b'1', 3),
(7, 'Episode 1', 38, b'1', 4);

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `link` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `episode_id` int(11) NOT NULL,
  `server_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`id`, `link`, `message`, `status`, `episode_id`, `server_id`) VALUES
(1, 'https://www.youtube.com/embed/cbuZfY2S2UQ', 'No Error', b'1', 1, 2),
(2, 'https://www.youtube.com/embed/E5dlaTkM8L4?rel=1', 'No Error', b'1', 3, 2),
(3, 'https://www.youtube.com/embed/QZr8rhp5y7s', NULL, b'1', 4, 2),
(4, 'https://www.dailymotion.com/embed/video/x40j97f?autoplay=1', NULL, b'1', 3, 3),
(5, 'https://www.dailymotion.com/embed/video/x40j97f?autoplay=1', 'Error', b'1', 5, 3),
(9, 'https://www.youtube.com/embed/NSuHuru1jSM?rel=0', 'No Error', b'0', 7, 2),
(12, 'https://www.dailymotion.com/embed/video/x7ybuw3?autoplay=1', 'No Error', b'1', 1, 3),
(13, 'https://player.vimeo.com/video/592798309?h=776d72a5ed&color=e700ef', 'No Error', b'1', 3, 4);

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `id` int(11) NOT NULL,
  `movie_comment` varchar(255) DEFAULT NULL,
  `movie_image` varchar(255) DEFAULT NULL,
  `movie_introduction` varchar(255) DEFAULT NULL,
  `movie_length` int(11) NOT NULL,
  `movie_name` varchar(255) DEFAULT NULL,
  `movie_trailer` varchar(255) DEFAULT NULL,
  `movie_type` varchar(255) DEFAULT NULL,
  `release_year` date DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `total_episodes` int(11) NOT NULL,
  `nation_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`id`, `movie_comment`, `movie_image`, `movie_introduction`, `movie_length`, `movie_name`, `movie_trailer`, `movie_type`, `release_year`, `status`, `total_episodes`, `nation_id`) VALUES
(1, 'https://www.facebook.com/movie/group5/1', 'https://img.movies2watch.tv/xxrz/250x400/279/95/bf/95bf03bbafb908d96cc699d43cf3a8ca/95bf03bbafb908d96cc699d43cf3a8ca.jpg', 'Anthony and his partner move into a loft in the now gentrified Cabrini-Green, and after a chance encounter with an old-timer exposes Anthony to the true story behind Candyman, he unknowingly opens a door to a complex past that unravels his own sanity and ', 128, 'Candyman', 'https://www.youtube.com/embed/TPBH3XO8YEU', 'SHORT', '2017-08-12', b'1', 1, 5),
(2, 'https://www.facebook.com/movie/group5/2', 'https://img.movies2watch.tv/xxrz/250x400/279/00/3d/003da01650614008382ebacdc72fee4e/003da01650614008382ebacdc72fee4e.jpg', 'The Candyman returns to try to convince his female descendent, an artist, to join him as a legendary figure. To this end, he frames her for a series of hideous murders of her friends and associates so that she has nowhere else to turn to.', 128, 'Candyman: Day of the Dead', 'https://www.youtube.com/embed/_v3xyZT9oA4', 'SHORT', '2020-08-03', b'1', 1, 5),
(3, 'https://www.facebook.com/movie/group5/3', 'https://img.movies2watch.tv/xxrz/250x400/279/88/54/8854b380ac2975d8aa9e088373d42819/8854b380ac2975d8aa9e088373d42819.jpg', 'By chance, a man and a woman meet on the KTX train and spend 24 hours in the unfamiliar city of Busan, South Korea', 110, 'Mood of the Day', 'https://www.youtube.com/embed/v_yA_KNTVCs', 'SHORT', '2016-08-18', b'1', 1, 3),
(4, 'https://www.facebook.com/movie/group5/4', 'https://img.movies2watch.tv/xxrz/250x400/279/1c/5b/1c5b3c588aaa350893f957946f973f6d/1c5b3c588aaa350893f957946f973f6d.jpg', 'Talon, the lone survivor of a race called the Blackbloods, sets off to the edge of civilisation to track her family\'s killers. On her journey she discovers she has supernatural powers which she must learn to harness in order to achieve her goals.', 45, 'The Outpost', 'https://www.youtube.com/embed/Kp9JghhGPao', 'SERIES', '2019-08-16', b'1', 12, 5),
(5, 'https://www.facebook.com/movie/group5/5', 'https://img.movies2watch.tv/xxrz/250x400/279/28/46/2846756d75705a513715e906c1494b98/2846756d75705a513715e906c1494b98.jpg', 'The Last Warrior mang đến một thế giới pha lẫn huyền bí và hiện đại khi xoay quanh Ivan Naydenov (Viktor Khorinyak) – một chàng trai mồ côi sống tại Moscow bằng nghề lừa đảo. Ivan tự nhận là “pháp sư trắng” và thường xuyên dùng những trò ảo thuật tâm linh', 128, 'The Card Counter', 'https://www.youtube.com/embed/zia6QXtrEJI', 'SHORT', '2021-08-02', b'1', 1, 5),
(6, 'https://www.facebook.com/movie/group5/6', 'https://img.movies2watch.tv/xxrz/250x400/279/5c/b5/5cb565d9dd1bf661bf3583d329553591/5cb565d9dd1bf661bf3583d329553591.jpg', 'Robin Wiltshire\'s painful childhood was rescued by Westerns. Now he lives on the frontier of his dreams, training the horses he loves for the big screen.', 150, 'My Heroes Were Cowboys', 'https://www.youtube.com/embed/ySlGTnmRHtk', 'SHORT', '2021-08-11', b'1', 1, 5),
(7, 'https://www.facebook.com/movie/group5/7', 'https://img.movies2watch.tv/xxrz/250x400/279/3c/0a/3c0ab1c2958b4013b840302c2cca641d/3c0ab1c2958b4013b840302c2cca641d.jpg', 'At the height of the Cold War, a troubled soldier forms a forbidden love triangle with a daring fighter pilot and his female comrade amid the dangerous surroundings of a Soviet Air Force Base.', 120, 'Firebird', 'https://www.youtube.com/embed/ngk2j1TUz88', 'SHORT', '2021-08-10', b'1', 1, 5),
(8, 'https://www.facebook.com/movie/group5/8', 'https://img.movies2watch.tv/xxrz/250x400/279/26/b4/26b4d49c250b8cf41517a103279166a9/26b4d49c250b8cf41517a103279166a9.jpg', 'Jamie New is 16 and doesn’t quite fit in—instead of pursuing a \"real\" career he dreams of becoming a drag queen. Uncertain about his future, Jamie knows one thing for sure: he is going to be a sensation. Supported by his loving mom and his amazing friends', 110, 'Everybody\'s Talking About Jamie', 'https://www.youtube.com/embed/CpOeZw7xdfI', 'SHORT', '2021-08-18', b'1', 1, 7),
(9, 'https://www.facebook.com/movie/group5/9', 'https://img.movies2watch.tv/xxrz/250x400/279/6b/5a/6b5a6bdb5ae05c25c70bfe21466c7707/6b5a6bdb5ae05c25c70bfe21466c7707.jpg', 'A family on a tropical holiday discovers that the secluded beach where they are staying is somehow causing them to age rapidly, reducing their entire lives into a single day.', 110, 'Old', 'https://www.youtube.com/embed/A4U2pMRV9_k', 'SHORT', '2021-08-09', b'1', 1, 3),
(11, 'https://www.facebook.com/movie/group5/10', 'https://img.movies2watch.tv/xxrz/250x400/279/dd/b2/ddb252669a4d1bb333f3d5839e0d8c1f/ddb252669a4d1bb333f3d5839e0d8c1f.jpg', 'A PhD student ties unusual tremors in Los Angeles to rogue scientists, who will weaponize Nikola Tesla\'s secrets and cause massive earthquakes, if they can only find his lost notebook', 120, 'Final Frequency', 'https://www.youtube.com/embed/beCvkVd7BXQ', 'SHORT', '2021-08-27', b'1', 1, 6),
(12, 'https://www.facebook.com/movie/group5/11', 'https://img.movies2watch.tv/xxrz/250x400/279/16/e8/16e8ec1e2fed989ddad5c08e319e700b/16e8ec1e2fed989ddad5c08e319e700b.jpg', '\r\nNicolas Bannister, a rugged and solitary veteran living in a near-future Miami flooded by rising seas, is an expert in a dangerous occupation: he offers clients the chance to relive any memory they desire. His life changes when he meets a mysterious you', 120, 'Reminiscence', 'https://www.youtube.com/embed/_BggT--yxf0', 'SHORT', '2021-09-09', b'1', 1, 5),
(13, 'https://www.facebook.com/movie/group5/12', 'https://img.movies2watch.tv/xxrz/250x400/279/fb/34/fb3406955f5d305bb7ce6f9cf2afc7a7/fb3406955f5d305bb7ce6f9cf2afc7a7.jpg', 'Tells the story of a tough and rogue female prosecutor, who one day loses all of her memories and changes places with a conservative housewife who looks just like her.', 24, 'One The Woman', 'https://www.youtube.com/embed/t3zcuXdKOl8', 'SERIES', '2018-09-08', b'1', 18, 3),
(14, 'https://www.facebook.com/movie/group5/13', 'https://img.movies2watch.tv/xxrz/250x400/279/6f/35/6f35fd45d25b1c4e33d4f72f2e395815/6f35fd45d25b1c4e33d4f72f2e395815.jpg', 'Yumi is a 30-year old, ordinary woman who struggles with expressing her feelings. Told from the perspective of the many brain cells in her head, she experiences growth in both her love life, her career, and finds happiness in the small joys of everyday li', 45, 'Yumi\'s Cells', 'https://www.youtube.com/embed/Yn8S5bNphs4', 'SERIES', '2015-09-15', b'1', 5, 3),
(19, 'https://www.facebook.com/movie/group5/14', 'https://img.movies2watch.tv/xxrz/250x400/279/8d/a6/8da6cf7c651db423de7a502e25084ac7/8da6cf7c651db423de7a502e25084ac7.jpg', 'Hundreds of cash-strapped players accept a strange invitation to compete in children\'s games. Inside, a tempting prize awaits — with deadly high stakes.', 45, 'Squid Game', 'https://www.youtube.com/embed/oqxAJKy0ii4', 'SERIES', '2021-09-29', b'1', 15, 1),
(20, 'https://www.facebook.com/movie/group5/15', 'https://img.movies2watch.tv/xxrz/250x400/279/26/d8/26d82540fd4a3ba6e2069ca3df9d1109/26d82540fd4a3ba6e2069ca3df9d1109.jpg', 'In this sequel to The L Word, Beals, Moennig and Hailey will resume their original roles alongside a new generation of diverse, self-possessed LGBTQIA characters experiencing love, heartbreak, sex, setbacks and success in L.A.', 48, 'The L Word: Generation Q', 'https://www.youtube.com/embed/sK-wthQD8Zc', 'SERIES', '2021-07-13', b'1', 30, 10),
(21, 'https://www.facebook.com/movie/group5/16', 'https://img.movies2watch.tv/xxrz/250x400/279/58/7d/587db55543d500ccce34503ac2830660/587db55543d500ccce34503ac2830660.jpg', 'Follows Atlanta-based self-made multimillionaire Todd Chrisley, his devoted wife Julie and their five children who live a seemingly picture-perfect Southern life with everything money can buy.', 30, 'Chrisley Knows Best', 'https://www.youtube.com/embed/pCEr9gO3qGo', 'SERIES', '2021-09-28', b'1', 50, 7),
(22, 'https://www.facebook.com/movie/group5/17', 'https://img.movies2watch.tv/xxrz/250x400/279/c8/20/c8209a7b18d45dce84faece8113a52c4/c8209a7b18d45dce84faece8113a52c4.jpg', 'A team of young superheroes led by Nightwing (formerly Batman\'s first Robin) form to combat evil and other perils.', 48, 'Titans', 'https://www.youtube.com/embed/6ttU1iKSpdA', 'SERIES', '2021-09-15', b'1', 20, 4),
(23, 'https://www.facebook.com/movie/group5/18', 'https://img.movies2watch.tv/xxrz/250x400/279/e6/4e/e64eb4fc806e898549702a4e54b09ff5/e64eb4fc806e898549702a4e54b09ff5.jpg', 'Every day is extraordinary for five doctors and their patients inside a hospital, where birth, death and everything in between coexist.', 48, 'Hospital Playlist', 'https://www.youtube.com/embed/3azsTJH-VAI', 'SERIES', '2021-09-08', b'1', 34, 3),
(24, 'https://www.facebook.com/movie/group5/12', 'https://img.movies2watch.tv/xxrz/250x400/279/8f/88/8f8867d5bc90ed110ad24e86ef44b08c/8f8867d5bc90ed110ad24e86ef44b08c.jpg', 'With better luck, better choices, better posture...Josh Corman could’ve been a rock star. Now he teaches fifth grade, and though he loves his students, he still struggles to find happiness and meaning in a world that sometimes feels short on both.', 15, 'Mr. Corman', 'https://www.youtube.com/embed/JQg3m7RV-g4', 'SERIES', '2021-09-09', b'1', 10, 3);

-- --------------------------------------------------------

--
-- Table structure for table `movie_detail`
--

CREATE TABLE `movie_detail` (
  `id` int(11) NOT NULL,
  `follow` bit(1) NOT NULL,
  `rate` float NOT NULL,
  `status` bit(1) NOT NULL,
  `movie_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `nominations` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `movie_detail`
--

INSERT INTO `movie_detail` (`id`, `follow`, `rate`, `status`, `movie_id`, `user_id`, `nominations`) VALUES
(2, b'1', 3, b'1', 4, 1, b'0'),
(3, b'0', 0, b'1', 4, 2, b'1'),
(4, b'1', 4, b'1', 3, 1, b'0'),
(5, b'1', 4, b'1', 9, 1, b'1'),
(6, b'0', 5, b'1', 4, 3, b'0'),
(7, b'0', 4, b'1', 2, 1, b'1'),
(8, b'1', 0, b'1', 3, 6, b'0'),
(9, b'0', 4, b'1', 1, 6, b'0'),
(10, b'0', 0, b'1', 11, 6, b'0'),
(11, b'1', 0, b'1', 4, 6, b'0'),
(12, b'1', 0, b'1', 14, 6, b'1'),
(13, b'1', 0, b'1', 1, 1, b'1'),
(14, b'1', 0, b'1', 24, 1, b'1'),
(15, b'1', 0, b'1', 11, 1, b'1'),
(16, b'1', 0, b'1', 23, 1, b'1'),
(17, b'1', 0, b'1', 12, 1, b'1'),
(18, b'1', 0, b'1', 13, 1, b'1'),
(19, b'1', 0, b'1', 22, 6, b'1'),
(20, b'1', 0, b'1', 20, 6, b'1'),
(21, b'0', 3, b'1', 3, 11, b'0');

-- --------------------------------------------------------

--
-- Table structure for table `nation`
--

CREATE TABLE `nation` (
  `id` int(11) NOT NULL,
  `nation_name` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nation`
--

INSERT INTO `nation` (`id`, `nation_name`, `status`) VALUES
(1, 'Viet Nam', b'1'),
(3, 'Korea', b'1'),
(4, 'Japan', b'1'),
(5, 'America', b'1'),
(6, 'Australia', b'1'),
(7, 'England', b'1'),
(10, 'France', b'1'),
(11, 'China', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `provider`
--

CREATE TABLE `provider` (
  `id` int(11) NOT NULL,
  `provider_name` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `provider`
--

INSERT INTO `provider` (`id`, `provider_name`, `status`) VALUES
(1, 'System', b'1'),
(2, 'Gmail', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE `purchase` (
  `id` int(11) NOT NULL,
  `day` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`id`, `day`, `name`, `price`, `status`) VALUES
(1, 30, 'Package 1', 50000, b'1'),
(2, 120, 'Package 2', 90000, b'1');

-- --------------------------------------------------------

--
-- Table structure for table `purchase_detail`
--

CREATE TABLE `purchase_detail` (
  `id` int(11) NOT NULL,
  `create_at` datetime DEFAULT NULL,
  `purchase_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `serial_versionuid` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `role_name`, `status`, `serial_versionuid`) VALUES
(1, 'ROLE_ADMIN', b'1', 0),
(2, 'ROLE_MANAGER', b'1', 0),
(3, 'ROLE_MEMBER', b'1', 0),
(5, 'ROLE_MEMBER_VIP', b'1', 0);

-- --------------------------------------------------------

--
-- Table structure for table `server`
--

CREATE TABLE `server` (
  `id` int(11) NOT NULL,
  `server_config` varchar(255) DEFAULT NULL,
  `server_name` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `server`
--

INSERT INTO `server` (`id`, `server_config`, `server_name`, `status`) VALUES
(2, '<iframe  id=\"yt\" src=\"\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>', 'YT', b'1'),
(3, '<iframe frameborder=\"0\" id=\"yt\" type=\"text/html\" src=\"\"  allowfullscreen allow=\"autoplay\"> </iframe> ', 'DM', b'1'),
(4, '<iframe id=\"yt\" src=\"\"  frameborder=\"0\" allow=\"autoplay; fullscreen; picture-in-picture\" allowfullscreen></iframe>', 'VM', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `spring_session`
--

CREATE TABLE `spring_session` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `spring_session_attributes`
--

CREATE TABLE `spring_session_attributes` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `birthday` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `gender` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` bigint(20) NOT NULL,
  `status` bit(1) NOT NULL,
  `provider_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `birthday`, `email`, `fullname`, `gender`, `password`, `phone`, `status`, `provider_id`) VALUES
(1, '1999-08-13 00:00:00', 'phanhuyhoang783@gmail.com', 'Phan Huy Hoàng', b'1', '$2a$10$XOaQo3QVFG0SKfVuobwvru2YWm48cXyXtdPLyq9.0OJ3h0Y4xgWnu', 963603981, b'1', 1),
(2, '2021-08-16 00:00:00', 'huyhoang@gmail.com', 'Nguyễn Anh Hoàng', b'0', '$2a$10$w6x92Y5.TxMLySSDhwulJ.Hg8lVPJF0k5XDj4Jo6hgqRVUHVwRd4W', 266659987, b'1', 1),
(3, '2021-08-12 00:00:00', 'thanhduy@gmail.com', 'Trần Thanh Duy', b'0', '$2a$10$fBkhwjMlIIYTfojzFJbK2.yMBRc3nI0BU1C87aeMtRrgzmaRFfIai', 266659987, b'1', 1),
(6, '2021-09-01 00:00:00', 'nakai@gmail.com', 'Nakai', b'1', '$2a$10$kXhDHgiyN95wKMdSkZQFpeYJrHvPGnE83L7vpiEhscMgc89JyX0K.', 266659987, b'1', 1),
(11, '2021-09-18 00:00:00', 'hoang88362@nuce.edu.vn', 'Phan', b'0', '$2a$10$3pWWmts2xhV70GXGzp0hv.6Njq5iJSe2D8epe4liNZl5Ai/oL6S6q', 20, b'1', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 1),
(3, 2),
(6, 5),
(11, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `advertisement`
--
ALTER TABLE `advertisement`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category_detail`
--
ALTER TABLE `category_detail`
  ADD KEY `FKoacjquep8lngofusfbn6xraty` (`movie_id`),
  ADD KEY `FK1sd8561vgsmqkv7jq7sgbl21a` (`category_id`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8kcum44fvpupyw6f5baccx25c` (`user_id`);

--
-- Indexes for table `episode`
--
ALTER TABLE `episode`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsbpb6q6d7t2jvwfwmlp0953e4` (`movie_id`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4dqh75hkiqvmfern9hx6ybrm6` (`episode_id`),
  ADD KEY `FK3k6rajh80oi8sjy96asro0gop` (`server_id`);

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnwp38qhras6o260ipvc7lgx2h` (`nation_id`);

--
-- Indexes for table `movie_detail`
--
ALTER TABLE `movie_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKh7u9ooxnuy4p1894iwh7xb8ps` (`movie_id`),
  ADD KEY `FK7v209mlxkwprk4su2jmk96w74` (`user_id`);

--
-- Indexes for table `nation`
--
ALTER TABLE `nation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `provider`
--
ALTER TABLE `provider`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `purchase_detail`
--
ALTER TABLE `purchase_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK65hoe4yy1817l2vm74msb8eq5` (`purchase_id`),
  ADD KEY `FK3m4he90fhntiatrh57eveibnk` (`user_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `server`
--
ALTER TABLE `server`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `spring_session`
--
ALTER TABLE `spring_session`
  ADD PRIMARY KEY (`PRIMARY_ID`),
  ADD UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  ADD KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  ADD KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`);

--
-- Indexes for table `spring_session_attributes`
--
ALTER TABLE `spring_session_attributes`
  ADD PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKn6etho5ib8edbe8siyh915vcn` (`provider_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `advertisement`
--
ALTER TABLE `advertisement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `episode`
--
ALTER TABLE `episode`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `movie`
--
ALTER TABLE `movie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `movie_detail`
--
ALTER TABLE `movie_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `nation`
--
ALTER TABLE `nation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `provider`
--
ALTER TABLE `provider`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `purchase`
--
ALTER TABLE `purchase`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `purchase_detail`
--
ALTER TABLE `purchase_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `server`
--
ALTER TABLE `server`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `category_detail`
--
ALTER TABLE `category_detail`
  ADD CONSTRAINT `FK1sd8561vgsmqkv7jq7sgbl21a` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  ADD CONSTRAINT `FKoacjquep8lngofusfbn6xraty` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`);

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `episode`
--
ALTER TABLE `episode`
  ADD CONSTRAINT `FKsbpb6q6d7t2jvwfwmlp0953e4` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`);

--
-- Constraints for table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `FK3k6rajh80oi8sjy96asro0gop` FOREIGN KEY (`server_id`) REFERENCES `server` (`id`),
  ADD CONSTRAINT `FK4dqh75hkiqvmfern9hx6ybrm6` FOREIGN KEY (`episode_id`) REFERENCES `episode` (`id`);

--
-- Constraints for table `movie`
--
ALTER TABLE `movie`
  ADD CONSTRAINT `FKnwp38qhras6o260ipvc7lgx2h` FOREIGN KEY (`nation_id`) REFERENCES `nation` (`id`);

--
-- Constraints for table `movie_detail`
--
ALTER TABLE `movie_detail`
  ADD CONSTRAINT `FK7v209mlxkwprk4su2jmk96w74` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKh7u9ooxnuy4p1894iwh7xb8ps` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`);

--
-- Constraints for table `purchase_detail`
--
ALTER TABLE `purchase_detail`
  ADD CONSTRAINT `FK3m4he90fhntiatrh57eveibnk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK65hoe4yy1817l2vm74msb8eq5` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`id`);

--
-- Constraints for table `spring_session_attributes`
--
ALTER TABLE `spring_session_attributes`
  ADD CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FKn6etho5ib8edbe8siyh915vcn` FOREIGN KEY (`provider_id`) REFERENCES `provider` (`id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
