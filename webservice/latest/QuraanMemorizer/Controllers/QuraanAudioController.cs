using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using QuraanMemorizer.Models;
using QuraanMemorizer.DAL;

namespace QuraanMemorizer.Controllers
{
    public class QuraanAudioController : ApiController
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET api/QuraanAudio
        public IQueryable<QuraanAudio> GetQuraanAudio(string Reciterid = null, string Audioname = null)
        {
            if (Reciterid != null)
                return db.QuraanAudio.Where(s=> s.ReciterId == int.Parse(Reciterid));
            if (Audioname != null)
                return db.QuraanAudio.Where(s=> s.AudioName == Audioname);
            return db.QuraanAudio;
        }

        // GET api/QuraanAudio/5
        [ResponseType(typeof(QuraanAudio))]
        public IHttpActionResult GetQuraanAudio(int id)
        {
            QuraanAudio quraanaudio = db.QuraanAudio.Find(id);
            if (quraanaudio == null)
            {
                return NotFound();
            }

            return Ok(quraanaudio);
        }

        // PUT api/QuraanAudio/5
        public IHttpActionResult PutQuraanAudio(int id, QuraanAudio quraanaudio)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != quraanaudio.Id)
            {
                return BadRequest();
            }

            db.Entry(quraanaudio).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!QuraanAudioExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST api/QuraanAudio
        [ResponseType(typeof(QuraanAudio))]
        public IHttpActionResult PostQuraanAudio(QuraanAudio quraanaudio)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.QuraanAudio.Add(quraanaudio);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = quraanaudio.Id }, quraanaudio);
        }

        // DELETE api/QuraanAudio/5
        [ResponseType(typeof(QuraanAudio))]
        public IHttpActionResult DeleteQuraanAudio(int id)
        {
            QuraanAudio quraanaudio = db.QuraanAudio.Find(id);
            if (quraanaudio == null)
            {
                return NotFound();
            }

            db.QuraanAudio.Remove(quraanaudio);
            db.SaveChanges();

            return Ok(quraanaudio);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool QuraanAudioExists(int id)
        {
            return db.QuraanAudio.Count(e => e.Id == id) > 0;
        }
    }
}